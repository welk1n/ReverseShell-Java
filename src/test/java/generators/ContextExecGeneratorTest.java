package generators;

import org.junit.Test;
import static org.junit.Assert.*;

import javax.el.ELProcessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


public class ContextExecGeneratorTest {

    public static ContextExecGenerator generator = new ContextExecGenerator(new Listener("",5555));

    @Test
    public void getEvilELCode() {
        ELProcessor elProcessor = new ELProcessor();
        String payload = generator.getEvilELCode();
        elProcessor.eval(payload);
    }

    @Test
    public void getEvilSpelCode(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(generator.getEvilSpelCode());
        EvaluationContext context = new StandardEvaluationContext();

        Object message = exp.getValue(context);
        System.out.println(message);
    }

}