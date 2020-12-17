package antivirus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FinestraQuery extends JFrame {

	private JPanel contentPane;

	// Creazione del frame
	public FinestraQuery() {
		super("Antivirus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextArea Results = new JTextArea();
		Results.setEditable(false);
		JScrollPane scrollV = new JScrollPane(Results);
		scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollV, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 2));
		contentPane.add(panel, BorderLayout.WEST);
		// Fine creazione del frame

		// Query1
		JButton btnNewButton_1 = new JButton("Insert Privato");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 250);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(5, 1));
				panel1.add(new JLabel("Codice fiscale"));
				panel1.add(new JLabel("Nome"));
				panel1.add(new JLabel("Cognome"));
				panel1.add(new JLabel("Email Cliente"));
				panel1.add(new JLabel("Telefono Cliente"));

				tmp.add(panel1);
				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(5, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);

				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
					
					try
					{
						Interface.query1(t1.getText(),t2.getText(), t3.getText(), t4.getText(), t5.getText());
						Results.setText("Privato Aggiunto!");
						tmp.dispose();
					}
					
					catch (NumberFormatException e) {
						System.out.println(e);
						JPanel panelerror = new JPanel();
						JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
								JOptionPane.ERROR_MESSAGE);
					}
					
					}
				});
				tmp.add(btn);

			}
		});

		panel.add(btnNewButton_1);

		// Query2
		JButton btnNewButton_2 = new JButton("Insert Azienda");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 300);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(7, 1));
				panel1.add(new JLabel("P.Iva"));
				panel1.add(new JLabel("Nome Azienda"));
				panel1.add(new JLabel("Nome titolare"));
				panel1.add(new JLabel("Cognome titolare"));
				panel1.add(new JLabel("Numero Licenze"));
				panel1.add(new JLabel("Email Cliente"));
				panel1.add(new JLabel("Telefono Cliente"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();
				JTextField t7 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(7, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t6);
				panel.add(t7);

				tmp.add(panel);

				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query2( t1.getText(), t2.getText(), t3.getText(),t4.getText(),Integer.parseInt(t5.getText()),t6.getText(),t7.getText());
							Results.setText("Azienda aggiunta");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel pane = new JPanel();
							JOptionPane.showMessageDialog(pane, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});

				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_2);

		// Query3
		JButton btnNewButton_3 = new JButton("Insert Licenza Azienda");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 200);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(6, 1));

				panel1.add(new JLabel("Seriale"));
				panel1.add(new JLabel("Tipo"));
				panel1.add(new JLabel("Prezzo"));
				panel1.add(new JLabel("Scadenza"));
				panel1.add(new JLabel("P.Iva Azienda"));
				panel1.add(new JLabel("Antivirus Associato"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(6, 1));

				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t6);
				
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						try {
							Interface.query3(t1.getText(),t2.getText(),Float.parseFloat(t3.getText()),t4.getText(),t5.getText(),t6.getText());
							Results.setText("Licenza aggiunta!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_3);

		// Query4
		JButton btnNewButton_4 = new JButton("Insert Antivirus");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(400, 100);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(3, 1));
				panel1.add(new JLabel("Nome Antivirus"));
				panel1.add(new JLabel("Versione"));
				panel1.add(new JLabel("Tipo"));
				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query4(t1.getText(), Integer.parseInt(t2.getText()), t3.getText());
							Results.setText("Antivirus aggiunto!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_4);

		// Query5
		JButton btnNewButton_5 = new JButton("Insert Virus Conosciuto");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 150);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(5, 1));
				panel1.add(new JLabel("Nome Virus"));
				panel1.add(new JLabel("Tipo"));
				panel1.add(new JLabel("Data primo rilevamento"));
				panel1.add(new JLabel("Data aggiornamento"));
				panel1.add(new JLabel("Sistema Afflitto"));
				panel1.add(new JLabel("Antivirus Associato"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(5, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query5(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText());
							Results.setText("Virus aggiunto!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_5);

		// Query6
		JButton btnNewButton_6 = new JButton("Insert Licenza");
		btnNewButton_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 150);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(6, 1));
				panel1.add(new JLabel("Seriale"));
				panel1.add(new JLabel("Tipo"));
				panel1.add(new JLabel("Prezzo"));
				panel1.add(new JLabel("Scadenza"));
				panel1.add(new JLabel("Codice Cliente"));
				panel1.add(new JLabel("Antivirus Associato"));
				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(6, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t6);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query6(t1.getText(), t2.getText(), Float.parseFloat(t3.getText()), t4.getText(),
									Integer.parseInt(t5.getText()), t6.getText());
							Results.setText("Licenza aggiunta!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancantiInserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});

		panel.add(btnNewButton_6);

		// Query6
		JButton btnNewButton_7 = new JButton("Insert Sistema Afflitto");
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 150);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(1, 1));
				panel1.add(new JLabel("Nome sistema afflitto"));
				tmp.add(panel1);

				JTextField t1 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(1, 1));
				panel.add(t1);

				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query7(t1.getText());
							Results.setText("Sistema aggiunto!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});

		panel.add(btnNewButton_7);

		// Query 8
		JButton btnNewButton_8 = new JButton("Insert log scansione");
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 300);
				tmp.setLayout(new GridLayout(1, 7));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(5, 1));
				panel1.add(new JLabel("Data inizio scansione"));
				panel1.add(new JLabel("Data completamento scansione"));
				panel1.add(new JLabel("Numero oggetti controllati"));
				panel1.add(new JLabel("Versione motore database"));
				panel1.add(new JLabel("Nome antivirus usato"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(5, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);

				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query8(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),
									Integer.parseInt(t4.getText()), t5.getText());
							Results.setText("Log scansione aggiunto!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});

		panel.add(btnNewButton_8);

		// Query 9
		JButton btnNewButton_9 = new JButton("Insert Quarantena");
		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 300);
				tmp.setLayout(new GridLayout(1, 7));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(4, 1));
				panel1.add(new JLabel("Motivo"));
				panel1.add(new JLabel("Data"));
				panel1.add(new JLabel("Dimensione"));
				panel1.add(new JLabel("Numero totale"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(4, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);

				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query9(t1.getText(), t2.getText(), Float.parseFloat(t3.getText()),
									Integer.parseInt(t4.getText()));
							Results.setText("Quarantena aggiunta!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});

		panel.add(btnNewButton_9);

		// Query 10
		JButton btnNewButton_10 = new JButton("Insert Virus");
		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 300);
				tmp.setLayout(new GridLayout(1, 7));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(6, 1));
				panel1.add(new JLabel("Nome Virus"));
				panel1.add(new JLabel("Data Rilevamento"));
				panel1.add(new JLabel("Percorso"));
				panel1.add(new JLabel("Tipo"));
				panel1.add(new JLabel("Motivo Quarantena"));
				panel1.add(new JLabel("Rilevato da"));

				tmp.add(panel1);

				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(6, 1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t6);

				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query10(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
									t6.getText());
							Results.setText("Virus aggiunto!");
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});

		panel.add(btnNewButton_10);

		// Select Op11
		JButton btnNewButton_11 = new JButton("Select Op11");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 100);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new BorderLayout());
				panel1.add(new JLabel("Nome Sistema"));
				tmp.add(panel1, BorderLayout.WEST);

				JTextField t1 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3, 1));
				panel.add(new JPanel());
				panel.add(t1, BorderLayout.CENTER);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Results.setText("Stampare il nome dei virus rilevati su " + t1.getText() + ".\n\n"
								+ Interface.query11(t1.getText()));

						tmp.dispose();
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btnNewButton_11);

		// Select op12
		JButton btnNewButton_12 = new JButton("Select Op12");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText("Stampare il codice delle scansioni che hanno impiegato meno di 20 minuti.\n\n"
						+ Interface.query12());
			}
		});
		panel.add(btnNewButton_12);

		// Select op13
		JButton btnNewButton_13 = new JButton("Select Op13");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 100);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new BorderLayout());
				panel1.add(new JLabel("Numero virus"));
				tmp.add(panel1, BorderLayout.WEST);

				JTextField t1 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3, 1));
				panel.add(new JPanel());
				panel.add(t1, BorderLayout.CENTER);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Results.setText("Stampare il numero di sistemi che sono afflitti da piú di "
									+ Integer.parseInt(t1.getText()) + " virus.\n\n"
									+ Interface.query13(Integer.parseInt(t1.getText())));
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btnNewButton_13);

		// Select op14
		JButton btnNewButton_14 = new JButton("Select Op14");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(
						"Stampare nome e p.iva delle aziende che hanno acquistato antivirus che contengono la parola “Avast”.\n\n"
								+ Interface.query14());
			}
		});
		panel.add(btnNewButton_14);

		// Select Op15
		JButton btnNewButton_15 = new JButton("Select Op15");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(
						"Stampare il nome delle aziende ordinate in modo decrescente rispetto al numero di licenze acquistate.\n\n"
								+ Interface.query15());

			}
		});
		panel.add(btnNewButton_15);

		// Select Op16
		JButton btnNewButton_16 = new JButton("Select Op16");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(
						"Contare il numero di licenze di tipo aziendale la cui scadenza è tra Marzo e Settembre 2021.\n\n"
								+ Interface.query16());

			}
		});
		panel.add(btnNewButton_16);

		// Select Op17
		JButton btnNewButton_17 = new JButton("Select Op17");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 100);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new BorderLayout());
				panel1.add(new JLabel("Nome antivirus"));
				tmp.add(panel1, BorderLayout.WEST);

				JTextField t1 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3, 1));
				panel.add(new JPanel());
				panel.add(t1, BorderLayout.CENTER);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Results.setText("Stampare il nome dei virus che non sono mai stati rilevati da "
									+ t1.getText() + " .\n\n" + Interface.query17(t1.getText()));
							tmp.dispose();
						} catch (NumberFormatException e) {
							System.out.println(e);
							JPanel panelerror = new JPanel();
							JOptionPane.showMessageDialog(panelerror, "Dati sbagliati o mancanti. Inserisci i dati correttamente!", "Errore!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btnNewButton_17);

		// Select Op18
		JButton btnNewButton_18 = new JButton("Select Op18");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp = new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 100);
				tmp.setLayout(new GridLayout(1, 3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new BorderLayout());
				panel1.add(new JLabel("Numero log prodotti"));
				tmp.add(panel1, BorderLayout.WEST);

				JTextField t1 = new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3, 1));
				panel.add(new JPanel());
				panel.add(t1, BorderLayout.CENTER);
				tmp.add(panel);
				JButton btn = new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						Results.setText(
								"Stampare il nome degli antivirus di tipo Antimalware che hanno prodotto piú di "
										+ Integer.parseInt(t1.getText()) + " log scansioni.\n\n"
										+ Interface.query18(Integer.parseInt(t1.getText())));
						tmp.dispose();
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btnNewButton_18);

		// Select Op19
		JButton btnNewButton_19 = new JButton("Select Op19");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(
						"Stampare le informazioni della quarantene che hanno una dimensione che superi la dimensione media di tutte le quarantene.\n\n"
								+ Interface.query19());

			}
		});
		panel.add(btnNewButton_19);

		JButton btnNewButton_20 = new JButton("CONNESSIONE");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Interface.connessione());
			}
		});

		JButton btnNewButton_21 = new JButton("DISCONNESSIONE");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Interface.disconnessione());

			}
		});

		JButton btnNewButton_22 = new JButton("LISTA OPERAZIONI");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Interface.lista_op());

			}
		});

		JPanel bt = new JPanel();
		bt.setVisible(true);
		bt.setLayout(new GridLayout(1, 4));

		bt.add(new JPanel());
		bt.add(btnNewButton_20);
		bt.add(btnNewButton_21);
		bt.add(btnNewButton_22);

		bt.add(new JPanel());

		contentPane.add(bt, BorderLayout.NORTH);
		setVisible(true);
	}

}
