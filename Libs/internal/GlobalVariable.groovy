package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL_Region
     
    /**
     * <p></p>
     */
    public static Object email
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object URL_Project
     
    /**
     * <p></p>
     */
    public static Object URL_CostCodes
     
    /**
     * <p></p>
     */
    public static Object URL_RequestType
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object timeOut
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            URL_Region = selectedVariables['URL_Region']
            email = selectedVariables['email']
            password = selectedVariables['password']
            URL_Project = selectedVariables['URL_Project']
            URL_CostCodes = selectedVariables['URL_CostCodes']
            URL_RequestType = selectedVariables['URL_RequestType']
            URL = selectedVariables['URL']
            timeOut = selectedVariables['timeOut']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
