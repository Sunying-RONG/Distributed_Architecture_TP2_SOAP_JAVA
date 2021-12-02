
package ClientWSDL;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeService", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeService {


    /**
     * 
     * @return
     *     returns java.util.List<ClientWSDL.Employee>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployees", targetNamespace = "http://service/", className = "ClientWSDL.GetEmployees")
    @ResponseWrapper(localName = "getEmployeesResponse", targetNamespace = "http://service/", className = "ClientWSDL.GetEmployeesResponse")
    @Action(input = "http://service/EmployeeService/getEmployeesRequest", output = "http://service/EmployeeService/getEmployeesResponse")
    public List<Employee> getEmployees();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns ClientWSDL.Employee
     * @throws AlreadyExist_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEmployee", targetNamespace = "http://service/", className = "ClientWSDL.AddEmployee")
    @ResponseWrapper(localName = "addEmployeeResponse", targetNamespace = "http://service/", className = "ClientWSDL.AddEmployeeResponse")
    @Action(input = "http://service/EmployeeService/addEmployeeRequest", output = "http://service/EmployeeService/addEmployeeResponse", fault = {
        @FaultAction(className = AlreadyExist_Exception.class, value = "http://service/EmployeeService/addEmployee/Fault/AlreadyExist")
    })
    public Employee addEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws AlreadyExist_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns ClientWSDL.Employee
     * @throws NotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployee", targetNamespace = "http://service/", className = "ClientWSDL.GetEmployee")
    @ResponseWrapper(localName = "getEmployeeResponse", targetNamespace = "http://service/", className = "ClientWSDL.GetEmployeeResponse")
    @Action(input = "http://service/EmployeeService/getEmployeeRequest", output = "http://service/EmployeeService/getEmployeeResponse", fault = {
        @FaultAction(className = NotFound_Exception.class, value = "http://service/EmployeeService/getEmployee/Fault/NotFound")
    })
    public Employee getEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws NotFound_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns ClientWSDL.Employee
     * @throws NotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateEmployee", targetNamespace = "http://service/", className = "ClientWSDL.UpdateEmployee")
    @ResponseWrapper(localName = "updateEmployeeResponse", targetNamespace = "http://service/", className = "ClientWSDL.UpdateEmployeeResponse")
    @Action(input = "http://service/EmployeeService/updateEmployeeRequest", output = "http://service/EmployeeService/updateEmployeeResponse", fault = {
        @FaultAction(className = NotFound_Exception.class, value = "http://service/EmployeeService/updateEmployee/Fault/NotFound")
    })
    public Employee updateEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws NotFound_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws NotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteEmployee", targetNamespace = "http://service/", className = "ClientWSDL.DeleteEmployee")
    @ResponseWrapper(localName = "deleteEmployeeResponse", targetNamespace = "http://service/", className = "ClientWSDL.DeleteEmployeeResponse")
    @Action(input = "http://service/EmployeeService/deleteEmployeeRequest", output = "http://service/EmployeeService/deleteEmployeeResponse", fault = {
        @FaultAction(className = NotFound_Exception.class, value = "http://service/EmployeeService/deleteEmployee/Fault/NotFound")
    })
    public boolean deleteEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws NotFound_Exception
    ;

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://service/", className = "ClientWSDL.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://service/", className = "ClientWSDL.CountResponse")
    @Action(input = "http://service/EmployeeService/countRequest", output = "http://service/EmployeeService/countResponse")
    public int count();

}