import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FuncionarioProxyTest {
    @BeforeEach
    void setUp() {
        BancoDados.addFuncionario(new Funcionario("1", "João", 950.0f));
        BancoDados.addFuncionario(new Funcionario("2", "Maria", 1000.0f));
    }

    @Test
    void deveRetornarDadosPessoaisDosFuncionarios() {
        FuncionarioProxy funcionario = new FuncionarioProxy("1");
        assertEquals(Arrays.asList("João"), funcionario.obterDadosPessoais());
    }



    @Test
    void deveRetonarSalarioFuncionario() {
        Empresario empresario= new Empresario("Mariana", true);
        FuncionarioProxy funcionario = new FuncionarioProxy("2");

        assertEquals(Arrays.asList(1000.0f), funcionario.obterSalario(empresario));
    }


    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarSalarioFuncionario() {
        try {
            Empresario empresario = new Empresario("Michel", false);
            FuncionarioProxy funcionario = new FuncionarioProxy("3");

            funcionario.obterSalario(empresario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Socio nao autorizado", e.getMessage());
        }
    }
}
