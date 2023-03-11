import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("QUESTÃO 2");

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número interio para testar a questão 2: ");
        int n = scan.nextInt();
        Questao2.fibonacci(n);

        System.out.println("----------------------------------------------------");
        System.out.println("QUESTÃO 3");
        // Lê o arquivo JSON com os valores de faturamento diário
        List<FaturamentoDiario> faturamentoDiarioList = new ArrayList<>();
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("dados.json");
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            Gson gson = new Gson();
            FaturamentoDiario[] faturamentoDiarioArray = gson.fromJson(reader, FaturamentoDiario[].class);
            faturamentoDiarioList.addAll(Arrays.asList(faturamentoDiarioArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calcula o menor e o maior valor de faturamento diário
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        for (FaturamentoDiario faturamentoDiario : faturamentoDiarioList) {
            if (faturamentoDiario.getValor() < menorValor) {
                menorValor = faturamentoDiario.getValor();
            }
            if (faturamentoDiario.getValor() > maiorValor) {
                maiorValor = faturamentoDiario.getValor();
            }
        }
        System.out.println("Menor valor de faturamento diário: R$" + menorValor);
        System.out.println("Maior valor de faturamento diário: R$" + maiorValor);

        // Calcula a média mensal de faturamento diário
        double somaValores = 0.0;
        int numDias = 0;
        for (FaturamentoDiario faturamentoDiario : faturamentoDiarioList) {
            if (faturamentoDiario.getValor() > 0) { // Ignora dias sem faturamento
                somaValores += faturamentoDiario.getValor();
                numDias++;
            }
        }
        double mediaMensal = somaValores / numDias;

        // Calcula o número de dias em que o valor de faturamento diário foi superior à média mensal
        int numDiasSuperiores = 0;
        for (FaturamentoDiario faturamentoDiario : faturamentoDiarioList) {
            if (faturamentoDiario.getValor() > mediaMensal) {
                numDiasSuperiores++;
            }
        }
        System.out.println("Número de dias em que o valor de faturamento diário foi superior à média mensal: " + numDiasSuperiores);


        System.out.println("----------------------------------------------------");
        System.out.println("QUESTÃO 4");

        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        double totalFaturamento = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / totalFaturamento) * 100;
            System.out.printf("%s: %.2f%%\n", estado, percentual);
        }

        System.out.println("----------------------------------------------------");
        System.out.println("QUESTÃO 5");
        System.out.println("Digite qualquer coisa e veja como ela ficará com os caracteres invertidos: ");
        String normal = scan.next();
        String invertida = Questao5.inverterStrings(normal);
        System.out.println(invertida);


    }
}