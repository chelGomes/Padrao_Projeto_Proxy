import java.util.HashMap;
import java.util.Map;

public class BancoDados {
    private static Map<String, Funcionario> funcionarios = new HashMap<>();

    public static Funcionario getFuncionario(String cpf){
        return funcionarios.get(cpf);
    }

    public static void addFuncionario(Funcionario funcionario){
        funcionarios.put(funcionario.getMatricula(), funcionario);
    }
}
