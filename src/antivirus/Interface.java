package antivirus;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface {

	private static Connection con = null;

	public static String connessione() {

		try {
			// Creazione connessione
			Class.forName("com.mysql.cj.jdbc.Driver"); // Carico il Driver
			String url = "jdbc:mysql://localhost:3306/antivirus?useSSL=false&serverTimezone=Europe/Amsterdam";
			String username = "root";
			String pwd = "alessio99";
			con = DriverManager.getConnection(url, username, pwd);
			String msg = "Connessione riuscita!";
			return msg;
		} catch (Exception e) {
			return "Connessione fallita!";
		}
	}

	public static String disconnessione() {

		try {
			con.close();
			return "Connessione chiusa correttamente!\n";
		} catch (SQLException e) {
			return "Chiusura connessione fallita\n";
		}
	}

	public static String lista_op() {

		return "Op1: Inserire un nuovo cliente privato.\n\n" 
				+ "Op2:  Inserire un nuovo cliente azienda.\n\n"
				+ "Op3: Inserire una nuova licenza associata ad un’azienda.\n\n" 
				+ "Op4: Inserire un nuovo antivirus.\n\n"
				+ "Op5: Inserire un nuovo virus conosciuto.\n\n" 
				+ "Op6: Inserire una nuova licenza.\n\n"
				+ "Op7: Inserire un nuovo sistema.\n\n" 
				+ "Op8: Inserire un nuovo log scansione\n\n"
				+ "Op9: Inserire una nuova quarantena.\n\n" 
				+ "Op10: Inserire un nuovo virus.\n\n"
				+ "Op11: Stampare il nome dei virus rilevati su un sistema afflitto.\n\n"
				+ "Op12: Stampare il codice delle scansioni che hanno impiegato meno di 20 minuti.\n\n"
				+ "Op13: Stampare il numero di sistemi che sono afflitti da piú di un certo numero di virus.\n\n"
				+ "Op14: Stampare nome e p.iva delle aziende che hanno acquistato antivirus che contengono la parola “Avast”.\n\n"
				+ "Op15: Stampare il nome delle aziende ordinate in modo decrescente rispetto al numero di licenze acquistate.\n\n"
				+ "Op16: Contare il numero di licenze di tipo aziendale la cui scadenza è tra Marzo e Settembre 2021.\n\n"
				+ "Op17: Stampare il nome dei virus che non sono mai stati rilevati da un antivirus scelto.\n\n"
				+ "Op18: Stampare il nome degli antivirus di tipo Antimalware che hanno prodotto piú di un dato numero di log scansioni.\n\n"
				+ "Op19: Stampare le informazioni della quarantene che hanno una dimensione che superi la dimensione media di tutte le quarantene.\n";
	}

	// Insert Privato
	public static void query1(String codice_fiscale, String nome, String cognome,String email, String telefono) {

		try {
			String sql = "INSERT INTO cliente(email,telefono) VALUES(?,?);";
			String sql2 = "SELECT codice\r\n" 
						  + "FROM cliente\r\n"
						  + "WHERE email=? AND telefono=?\r\n";
			String sql3 = "INSERT INTO privato(codice_fiscale,nome,cognome,cliente_codice) VALUES(?,?,?,?)";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			PreparedStatement query3 = con.prepareStatement(sql3);
			
			
			query.setString(1, email);
			query.setString(2, telefono);
			query.executeUpdate();
			query.close();
			
			query2.setString(1, email);
			query2.setString(2, telefono);
			ResultSet result = query2.executeQuery();
			int cod_cliente=0;
			while (result.next()) {
				cod_cliente = result.getInt("codice");
				
			}
			
			query3.setString(1, codice_fiscale);
			query3.setString(2, nome);
			query3.setString(3, cognome);
			query3.setInt(4, cod_cliente);
			
			query2.close();
			query3.executeUpdate();
			query3.close();

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Insert Azienda
	public static void query2(String p_iva, String nome_azienda, String nome_titolare, String cognome_titolare,int n_licenze,String email, String telefono) {

		try {
			String sql = "INSERT INTO cliente(email,telefono) VALUES(?,?);";
			String sql2 = "SELECT codice\r\n" 
						  + "FROM cliente\r\n"
						  + "WHERE email=? AND telefono=?\r\n";
			String sql3 = "INSERT INTO azienda VALUES(?,?,?,?,?,?);";

			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			PreparedStatement query3 = con.prepareStatement(sql3);

			query.setString(1, email);
			query.setString(2, telefono);
			query.executeUpdate();
			query.close();
			
			query2.setString(1, email);
			query2.setString(2, telefono);
			ResultSet result = query2.executeQuery();
			int cod_cliente=0;
			while (result.next()) {
				cod_cliente = result.getInt("codice");
				
			}
			
			query3.setString(1, p_iva);
			query3.setString(2, nome_azienda);
			query3.setString(3, nome_titolare);
			query3.setString(4, cognome_titolare);
			query3.setInt(5, n_licenze);
			query3.setInt(6, cod_cliente);

			query2.close();
			query3.executeUpdate();
			query3.close();

		} catch (NumberFormatException | SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	// Insert licenza associata ad un'azienda
	public static void query3(String seriale, String tipo, Float prezzo, String scadenza,String piva,String nome_antivir) {

		try {

			String sql = "SELECT cliente_codice\r\n" 
					  + "FROM azienda\r\n"
					  + "WHERE p_iva=?\r\n";
			String sql2 = "INSERT INTO licenza VALUES (?,?,?,?,?,?);";

			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);

			query.setString(1, piva);
			ResultSet result = query.executeQuery();
			int cod_cliente=0;
			while (result.next()) {
				cod_cliente = result.getInt("cliente_codice");
				
			}
			
			query2.setString(1, seriale);
			query2.setString(2, tipo);
			query2.setFloat(3, prezzo);
			query2.setString(4, scadenza);
			query2.setInt(5, cod_cliente);
			query2.setString(6, nome_antivir);

			query.close();
			query2.executeUpdate();
			query2.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Insert Antivirus
	public static void query4(String nome, int versione, String tipo) {

		try {
			String sql = "INSERT INTO antivirus VALUES(?,?,?)";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, nome);
			query.setInt(2, versione);
			query.setString(3, tipo);
			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert virus conosciuto che fa riferimento un certo antivirus che attacca un
	// sistema
	public static void query5(String nome_vir,String tipo, String data_primor, String data_agg, String nome_sis,
			String nome_antivir) {

		try {

			String sql = "INSERT INTO virus_conosciuto VALUES (?,?,?,?);";
			String sql2 = "INSERT INTO attacca VALUES(?,?);";
			String sql3 = "INSERT INTO fa_riferimento VALUES(?,?);";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			PreparedStatement query3 = con.prepareStatement(sql3);
			query.setString(1, nome_vir);
			query.setString(2, tipo);
			query.setString(3, data_primor);
			query.setString(4, data_agg);
			query2.setString(1, nome_vir);
			query2.setString(2, nome_sis);
			query3.setString(1, nome_antivir);
			query3.setString(2, nome_vir);

			query.executeUpdate();
			query2.executeUpdate();
			query3.executeUpdate();
			query3.close();
			query2.close();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert di una nuova licenza acquistata da un certo cliente relativa ad un
	// antivirus
	public static void query6(String seriale, String tipo, Float prezzo, String scadenza, int cod_cliente,
			String nome_antivir) {

		try {

			String sql = "INSERT INTO licenza VALUES (?,?,?,?,?,?);";

			PreparedStatement query = con.prepareStatement(sql);

			query.setString(1, seriale);
			query.setString(2, tipo);
			query.setFloat(3, prezzo);
			query.setString(4, scadenza);
			query.setInt(5, cod_cliente);
			query.setString(6, nome_antivir);

			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert di un sistema afflitto
	public static void query7(String nome) {

		try {

			String sql = "INSERT INTO sistema_afflitto VALUES (?);";

			PreparedStatement query = con.prepareStatement(sql);

			query.setString(1, nome);

			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert di un log scansione
	public static void query8(String data_ini, String data_fine, int n_ogg, int v_db, String nome_antivir) {

		try {

			String sql = "INSERT INTO log_scansione(data_inizio,data_completamento,n_oggetti_controllati,versione_database,antivirus_nome) VALUES (?,?,?,?,?);";

			PreparedStatement query = con.prepareStatement(sql);

			query.setString(1, data_ini);
			query.setString(2, data_fine);
			query.setInt(3, n_ogg);
			query.setInt(4, v_db);
			query.setString(5, nome_antivir);

			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert una quarantena
	public static void query9(String motivo, String data, float dimensione, int n_tot) {

		try {

			String sql = "INSERT INTO quarantena VALUES (?,?,?,?);";

			PreparedStatement query = con.prepareStatement(sql);

			query.setString(1, motivo);
			query.setString(2, data);
			query.setFloat(3, dimensione);
			query.setInt(4, n_tot);

			query.executeUpdate();
			query.close();
		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Insert un virus
	// Il virus potrebbe non essere in quarantena
	// se non é mai stato rilevato lo inserisco in virus e lo aggiungo in rilevato
	// settando il count a 1
	// se é stato rilevato aggiorno solo il count
	public static void query10(String nome_vir, String data, String percorso, String tipo, String quarantena_motivo,
			String nome_antiv) {
		try {
			quarantena_motivo = null;// il virus potrebbe non essere in quarantena
			String sql = "INSERT INTO virus(nome,data_rilevamento,percorso,tipo,quarantena_motivo) VALUES (?,?,?,?,?);";
			String sql2 = "SELECT n_virus_rilevati\r\n" + "from rileva\r\n"
					+ "WHERE virus_nome=? AND antivirus_nome=?;";
			String sql3 = "INSERT INTO rileva VALUES (?,?,?);";
			String sql4 = "UPDATE rileva n_virus_rilevati SET n_virus_rilevati=n_virus_rilevati+1 WHERE virus_nome=? AND antivirus_nome=?";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			PreparedStatement query3 = con.prepareStatement(sql3);
			PreparedStatement query4 = con.prepareStatement(sql4);

			query2.setString(1, nome_vir);
			query2.setString(2, nome_antiv);
			ResultSet result = null;
			result = query2.executeQuery();
			int num = 0;
			while (result.next()) {
				num = result.getInt("n_virus_rilevati");
				System.out.println(num);
			}
			if (num >= 1) {

				query4.setString(1, nome_vir);
				query4.setString(2, nome_antiv);
				query4.executeUpdate();
				query4.close();
			} else// eseguo l'insert poiché il virus non é stato ancora rilevato
			{
				query.setString(1, nome_vir);
				query.setString(2, data);
				query.setString(3, percorso);
				query.setString(4, tipo);
				query.setString(5, quarantena_motivo);
				query.executeUpdate();
				query.close();
				query3.setString(1, nome_vir);
				query3.setString(2, nome_antiv);
				query3.setInt(3, 1);
				query3.executeUpdate();
				query3.close();
			}

			result.close();
			query2.close();

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// Select op11
	public static String query11(String nome_sis) {

		String ris = "";
		try {

			String sql = "SELECT v.nome\r\n" + "FROM virus_conosciuto AS v,sistema_afflitto AS s,attacca AS a\r\n"
					+ "WHERE s.nome=? AND a.virus_conosciuto_nome=v.nome AND a.sistema_afflitto_nome=s.nome;";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, nome_sis);
			ResultSet result = query.executeQuery();
			while (result.next()) {
				String nome = result.getString("Nome");
				ris += "Nome virus: " + nome + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	// Select op12
	public static String query12() {

		String ris = "";
		try {

			String sql = "SELECT ls.codice,ls.data_inizio,ls.data_completamento\r\n" + "FROM log_scansione AS ls\r\n"
					+ "WHERE TIMEDIFF(data_completamento,data_inizio)<'00:20:00'\r\n";

			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String codice = result.getString("ls.codice");
				String ini = result.getString("ls.data_inizio");
				String fine = result.getString("ls.data_completamento");
				ris += "Codice Log Scansione: " + codice + "\tData Inizio: " + ini + "\tData Completamento: " + fine
						+ "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select Op13
	public static String query13(int num) {

		String ris = "";
		try {

			String sql = "SELECT a.sistema_afflitto_nome,count(v.nome)\r\n"
					+ "FROM virus_conosciuto AS v,attacca AS a \r\n" + "WHERE a.virus_conosciuto_nome = v.nome \r\n"
					+ "group by a.sistema_afflitto_nome \r\n" + "having count(*)>? \r\n";

			PreparedStatement query = con.prepareStatement(sql);
			query.setInt(1, num);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String nome = result.getString("a.sistema_afflitto_nome");
				String count = result.getString("count(v.nome)");
				ris += "Nome sistema: " + nome + "\tNumero virus: " + count + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select Op14
	public static String query14() {

		String ris = "";
		try {
			String sql = "SELECT DISTINCT az.nome_azienda,az.p_iva \r\n"
					+ "FROM azienda AS az,cliente AS c,licenza AS l,antivirus AS an \r\n"
					+ "WHERE an.nome LIKE '%Avast%' AND az.cliente_codice=c.codice AND l.cliente_codice=c.codice AND l.antivirus_nome=an.nome\r\n";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String nome = result.getString("az.nome_azienda");
				String piva = result.getString("az.p_iva");
				ris += "Nome Azienda: " + nome + "\tP.IVA: " + piva + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	// Select op15
	public static String query15() {
		try {
			String ris = "";
			String sql = "SELECT nome_azienda,n_licenze\r\n" + "FROM azienda \r\n" + "group by n_licenze \r\n"
					+ "order by nome_azienda DESC \r\n";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String nome = result.getString("nome_azienda");
				String n_lic = result.getString("n_licenze");
				ris += "Nome Azienda: " + nome + "\tNumero licenze: " + n_lic + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select op16
	public static String query16() {
		try {

			String ris = "";
			String sql = "SELECT count(*) as licenzeAziendali ,tipo\r\n" + "FROM licenza \r\n"
					+ "WHERE tipo='Aziendale' and scadenza between '2021-03-01' and '2021-05-01' \r\n";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String num = result.getString("licenzeAziendali");
				String tipo = result.getString("tipo");
				ris += "Numero licenze: " + num + "\tTipo licenza: " + tipo + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select op17
	public static String query17(String nome_anti) {
		try {

			String ris = "";
			String sql = "SELECT v.nome\r\n" + "FROM virus AS v \r\n" + "WHERE NOT EXISTS \r\n"
					+ "(SELECT r.virus_nome \r\n" + "FROM rileva AS r \r\n"
					+ "WHERE v.nome=virus_nome AND r.antivirus_nome= ?); \r\n";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, nome_anti);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String nome = result.getString("nome");
				ris += "Nome Virus: " + nome + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select op18
	public static String query18(int num) {
		try {

			String ris = "";
			String sql = "SELECT a.nome \r\n" + "FROM antivirus AS a \r\n" + "WHERE a.tipo='antimalware' AND ? \r\n"
					+ "< (SELECT count(*) \r\n" + "FROM log_scansione AS ls \r\n"
					+ "WHERE ls.antivirus_nome=a.nome); \r\n";
			PreparedStatement query = con.prepareStatement(sql);
			query.setInt(1, num);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String nome = result.getString("nome");
				ris += "Nome Antivirus: " + nome + "\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	// Select op19
	public static String query19() {
		try {
			String ris = "";
			String sql = "SELECT * \r\n" + "FROM quarantena \r\n" + "WHERE dimensione> \r\n"
					+ "(SELECT AVG(dimensione) \r\n" + "FROM quarantena); \r\n";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				String motivo = result.getString("motivo");
				String data = result.getString("dataq");
				Float dimensione = result.getFloat("dimensione");
				int n_tot = result.getInt("n_totale");
				ris += "Motivo: " + motivo + "\tData: " + data + "\tDimensione: " + dimensione
						+ "\tNumero Totale Virus: " + n_tot + "\t\n";

			}
			result.close();
			query.close();
			return ris;

		} catch (SQLException e) {
			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Inserisci i dati correttamente", "Dati sbagliati",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

}
