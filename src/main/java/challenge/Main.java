package challenge;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

	private File file;
	private BufferedReader br;
	private String cvsSplitBy = ",";
	private List<Jogador> jogadores = new ArrayList<>();

	public Main() throws FileNotFoundException {
		file = new File(getClass().getClassLoader().getResource("data.csv").getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			jogadores = br.lines().skip(1).map(line -> {
				String[] linha = line.split(cvsSplitBy);
				String nacionalidade = linha[14];
				String clube = linha[3];
				String nomeCompleto = linha[2];
				Double rescisao = linha[18].isEmpty() ? 0d : Double.parseDouble(linha[18]);
				Double salario = Double.parseDouble(linha[17]);
				LocalDate nascimento = LocalDate.parse(linha[8]);
				Integer idade = Integer.parseInt(linha[6]);
				return new Jogador(nacionalidade, clube, nomeCompleto, rescisao, salario, idade, nascimento);
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return (int) jogadores.stream().map(Jogador::getNacionalidade).distinct().count();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return (int) jogadores.stream().filter(jogador -> !jogador.getClube().isEmpty()).map(Jogador::getClube).distinct().count();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return jogadores.stream().map(Jogador::getNomeCompleto).limit(20).collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return jogadores
				.stream()
				.sorted(Comparator.comparingDouble(Jogador::getRescisao).reversed())
				.limit(10)
				.map(Jogador::getNomeCompleto)
				.collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		List<String> lista = this.jogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getNascimento).thenComparing(Jogador::getSalario))
				.limit(10)
				.map(Jogador::getNomeCompleto)
				.collect(toList());

		System.out.println(lista);
		return lista;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return jogadores
				.stream()
				.collect(groupingBy(Jogador::getIdade, counting()))
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
	}

}
