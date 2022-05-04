package api.atlantis.resource.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Department;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.mapstruct.dto.app.masterdata.general.DepartmentDto;
import api.atlantis.mapstruct.mappers.app.masterdata.general.DepartmentMapper;
import api.atlantis.mapstruct.validation.New;
import api.atlantis.mapstruct.validation.Existing;
import api.atlantis.service.interfaces.app.masterdata.general.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/masterdata/general/department")
public class DepartmentResource extends ExceptionHandling {
    private DepartmentService depService;
    private DepartmentMapper departmentMapper;

    public DepartmentResource(DepartmentService depService, DepartmentMapper departmentMapper) {
        this.depService = depService;
        this.departmentMapper = departmentMapper;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentMapper.toListDto(depService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DepartmentDto>> getFilteredDepartments(@RequestParam(name = "plantId") Long plantId) {
        return new ResponseEntity<>(departmentMapper.toListDto(depService.getDepartments(plantId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addNewDepartment(@Validated(Existing.class) @RequestBody DepartmentDto depDto) {
        Long newId = depService.addNew(departmentMapper.toEntity(depDto));
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updateDepartment(@Validated(New.class) @RequestBody DepartmentDto depDto) {
        Department dep = departmentMapper.toEntity(depDto);
        depService.update(dep);
        return new ResponseEntity<>(dep.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteDepartment(@PathVariable("id") Long id) {
        depService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
