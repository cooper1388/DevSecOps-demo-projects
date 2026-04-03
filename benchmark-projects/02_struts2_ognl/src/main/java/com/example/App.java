package com.example;

import com.opensymphony.xwork2.ActionSupport;

/**
 * VULNERABLE: Struts2 OGNL Injection (CVE-2021-31805, CVE-2023-50164)
 * ActionSupport expone evaluacion OGNL en parametros HTTP.
 * Un atacante envia: ?name=%25{(#rt=@java.lang.Runtime@getRuntime()).(#rt.exec('calc'))}
 */
public class App extends ActionSupport {
    private String name;
    private String fileUpload;  // CVE-2023-50164: file upload path traversal

    public String execute() {
        // VULNERABLE: Struts2 evalua OGNL en el parametro 'name'
        return SUCCESS;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFileUpload() { return fileUpload; }
    public void setFileUpload(String f) { this.fileUpload = f; }
}
