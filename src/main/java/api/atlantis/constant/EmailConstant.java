package api.atlantis.constant;

// constants for sending emails
public class EmailConstant {
    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_PORT = "mail.smtp.port";
    public static final int DEFAULT_PORT = 587;
    public static final String SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String EMAIL_CONTENT =
                            "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "  <head>\n" +
                            "    <meta charset=\"UTF-8\" />\n" +
                            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                            "    <title>Atlantis password reset template</title>\n" +
                            "    <style>\n" +
                            "      @import url(\"https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@400;700&display=swap\");\n" +
                            "      body {\n" +
                            "        background-color: #eef5f9;\n" +
                            "        height: 100vh;\n" +
                            "        margin: 0;\n" +
                            "      }\n" +
                            "      .container {\n" +
                            "        display: flex;\n" +
                            "        height: 100%;\n" +
                            "      }\n" +
                            "      .table {\n" +
                            "        margin: auto;\n" +
                            "        font-family: \"Nunito Sans\", sans-serif;\n" +
                            "        font-size: 0.875rem;\n" +
                            "        color: #3e5569;\n" +
                            "        box-shadow: 0 0 3px 1px #0000001a;\n" +
                            "        padding: 0.5rem;\n" +
                            "        background-color: white;\n" +
                            "      }\n" +
                            "      .header {\n" +
                            "        background-color: #00b0ff;\n" +
                            "        color: white;\n" +
                            "        font-size: 2rem;\n" +
                            "        font-weight: normal;\n" +
                            "        letter-spacing: 0.5rem;\n" +
                            "        padding: 0.5rem 7rem;\n" +
                            "      }\n" +
                            "      .separator {\n" +
                            "        border-bottom: 1px solid #00000040;\n" +
                            "        padding: 0.5rem;\n" +
                            "      }\n" +
                            "      .table-row {\n" +
                            "        padding-top: 1rem;\n" +
                            "      }\n" +
                            "      .username {\n" +
                            "        font-weight: bold;\n" +
                            "      }\n" +
                            "      .pwd {\n" +
                            "        font-weight: bold;\n" +
                            "      }\n" +
                            "      .footer {\n" +
                            "        text-align: center;\n" +
                            "        font-size: 0.8rem;\n" +
                            "        color: rgba(128, 128, 128, 0.7);\n" +
                            "      }\n" +
                            "    </style>\n" +
                            "  </head>\n" +
                            "  <body>\n" +
                            "    <div class=\"container\">\n" +
                            "      <table class=\"table\">\n" +
                            "        <tr>\n" +
                            "          <th class=\"header\">ATLANTIS</th>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"separator\"></td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"table-row\">\n" +
                            "            Hello <span class=\"username\">{username}</span>!\n" +
                            "          </td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"table-row\">\n" +
                            "            {registerResetPwd}\n" +
                            "          </td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"table-row\">{thePasswordIs}</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"table-row pwd\">{pwd}</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"separator\"></td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td class=\"table-row footer\">Atlantis support team</td>\n" +
                            "        </tr>\n" +
                            "      </table>\n" +
                            "    </div>\n" +
                            "  </body>\n" +
                            "</html>\n";
}
