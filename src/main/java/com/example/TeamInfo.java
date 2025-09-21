package com.example;
import java.awt.*;
import java.awt.event.*;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;




public class TeamInfo {
	private static int from_spec_to_id(String sp, String[] SpecializationS) {
		int id = 0;
		for (String i : SpecializationS) {
			if (sp.equals(i) == false) {
				id++;
			}
			else {
				return id;
			}
		}
		return id;
	}
	private static int from_ot_to_id(String ot, String[] OposTeamS) {
		int id = 0;
		for (String i : OposTeamS) {
			if (ot.equals(i) == false) {
				id++;
			}
			else {
				return id;
			}
		}
		return id;
	} 
	protected JFrame teams = new JFrame();
	protected JFrame sps = new JFrame();
	protected JButton Report_Xml1;
	protected JButton Report_PDF1;
	protected JButton Report_Xml2;
	protected JButton Report_PDF2;
	protected JLabel status1;
	protected JLabel status2;
    protected JFrame gameinfo;
	protected JLabel Name;
	protected String NameS;
	protected JLabel num_of_games;
    protected DefaultTableModel model1;
	protected String[][] data1;
	protected int len1;
	protected JButton save1;
	protected JButton add_el1;
	protected JButton delete_el1;
	protected JButton Players;
	protected JToolBar toolBar1;
	protected JScrollPane scroll1;
	protected JTable games;
	protected JFrame playerinfo;
	protected DefaultTableModel model2;
	protected String[][] data2;
	protected int len2;
	protected JButton save2;
	protected JButton add_el2;
	protected JButton delete_el2;
	protected JButton Games;
	protected JToolBar toolBar2;
	protected JScrollPane scroll2;
	protected JTable players;
	protected JComboBox<String> Specialization;
	protected String[] SpecializationS;
	protected JComboBox<String> OposTeam;
	protected String[] OposTeamS;
	protected JButton filter1;
	protected JButton filter2;
	protected JButton undoSelected1;
	protected JButton undoSelected2;
	private static final Logger logger = Logger.getLogger(TeamInfo.class);
	public void setOposTeamS(String[] sql_data) {
		OposTeamS = sql_data.clone();
	}
	public void setSpecializationS (String[] sql_data) {
		SpecializationS = sql_data.clone();
	}
	public void setNum_of_Games(int newval) {
		num_of_games = new JLabel(String.valueOf(newval));
	}
	public void setData1(String[][] sql_data) {
		data1 = sql_data.clone();
		len1 = data1.length;
	}
	public void setData2(String[][] sql_data) {
		data2 = sql_data.clone();
		len2 = data2.length;
	}
	public TeamInfo(String newval) {
		NameS = newval;
	}
	public TeamInfo() {}
	public void face() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.getLevel() == null) {
            logger.setLevel(org.apache.log4j.Level.INFO);
        }
		logger.info("The beginning of GUI initialization");
		try {
			gameinfo = new JFrame("Information about the games");
			logger.debug("The gameinfo frame has been created");
			gameinfo.setSize(700, 700);
			gameinfo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			playerinfo = new JFrame("Information about the players");
			logger.debug("The playerinfo frame has been created");
			playerinfo.setSize(1000, 700);
			playerinfo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			logger.info("Creating GUI components");
			Name = new JLabel(NameS);
			Name.setIcon(new ImageIcon("./icons/Zenit.jpg"));
			save1 = new JButton(new ImageIcon("./icons/save.png"));
			save1.setMaximumSize(new Dimension(50, 50));
			status1 = new JLabel("SAVED");
			add_el1 = new JButton(new ImageIcon("./icons/add_el.png"));
			add_el1.setMaximumSize(new Dimension(50, 50));
			delete_el1 = new JButton(new ImageIcon("./icons/delete_el.png"));
			delete_el1.setMaximumSize(new Dimension(50, 50));
			
			Players = new JButton("Players");
			Players.setMaximumSize(new Dimension(70, 50));

			save2 = new JButton(new ImageIcon("./icons/save.png"));
			save2.setMaximumSize(new Dimension(50, 50));
			status2 = new JLabel("SAVED");
			add_el2 = new JButton(new ImageIcon("./icons/add_el.png"));
			add_el2.setMaximumSize(new Dimension(50, 50));
			delete_el2 = new JButton(new ImageIcon("./icons/delete_el.png"));
			delete_el2.setMaximumSize(new Dimension(50, 50));
			
			Games = new JButton("Games");
			Games.setMaximumSize(new Dimension(60, 50));

			Report_Xml1 = new JButton(new ImageIcon("./icons/xml.png"));
			Report_Xml1.setMaximumSize(new Dimension(50,50));
			Report_PDF1 = new JButton(new ImageIcon("./icons/pdf.png"));
			Report_PDF1.setMaximumSize(new Dimension(50, 50));

			Report_Xml2 = new JButton(new ImageIcon("./icons/xml.png"));
			Report_Xml2.setMaximumSize(new Dimension(50,50));
			Report_PDF2 = new JButton(new ImageIcon("./icons/pdf.png"));
			Report_PDF2.setMaximumSize(new Dimension(50, 50));

			save1.setToolTipText("Save the table");
			add_el1.setToolTipText("Add an element");
			delete_el1.setToolTipText("Delete an element");
			
			save2.setToolTipText("Save the tableу");
			add_el2.setToolTipText("Add an element");
			delete_el2.setToolTipText("Delete an element");
			num_of_games.setMaximumSize(new Dimension(30, 30));

			Report_PDF1.setToolTipText("Create a pdf data file");
			Report_Xml1.setToolTipText("Create an xml data file");
			Report_PDF2.setToolTipText("Create a pdf data file");
			Report_Xml2.setToolTipText("Create an xml data file");
			toolBar1 = new JToolBar("The Game Panel");
			logger.info("Adding components to the toolbar");
			toolBar1.add(save1);
			toolBar1.add(add_el1);
			toolBar1.add(delete_el1);
			toolBar1.add(Report_Xml1);
			toolBar1.add(Report_PDF1);
			toolBar1.add(Players);
			toolBar1.add(new JLabel("Number of games: "));
			toolBar1.add(num_of_games);
			toolBar1.add(new JLabel("        "));
			toolBar1.add(status1);

			toolBar2 = new JToolBar("The Player Panel");
			toolBar2.add(save2);
			toolBar2.add(add_el2);
			toolBar2.add(delete_el2);
			toolBar2.add(Report_Xml2);
			toolBar2.add(Report_PDF2);
			toolBar2.add(Games);
			toolBar2.add(Name);
			toolBar2.add(new JLabel("        "));
			toolBar2.add(status2);


			gameinfo.setLayout(new BorderLayout());
			logger.debug("The layout for gameinfo is installed");
			playerinfo.setLayout(new BorderLayout());
			logger.debug("The layout for playerinfo is installed");
			playerinfo.add(toolBar2, BorderLayout.NORTH);
			gameinfo.add(toolBar1, BorderLayout.NORTH);
			String[] columns1 = {"ID", "The opposing team", "Score 1", "Score 2", "Date"};
			model1 = new DefaultTableModel(data1, columns1);
			games = new JTable(model1);
			scroll1 = new JScrollPane(games);
			logger.debug("Added scroll pane and table in gameinfo");
			gameinfo.add(scroll1, BorderLayout.CENTER);


			String[] columns2 = {"ID", "Name", "Result", "Specialization"};
			model2 = new DefaultTableModel(data2, columns2);
			players = new JTable(model2);
			scroll2 = new JScrollPane(players);
			logger.debug("Added scroll pane and table in playerinfo");
			playerinfo.add(scroll2, BorderLayout.CENTER);
			
			Specialization = new JComboBox<String>(SpecializationS);
			OposTeam = new JComboBox<String>(OposTeamS);
			filter1 = new JButton("Search");
			filter2 = new JButton("Search");

			logger.info("Adding filters");
			JPanel filter1Panel = new JPanel();
			JPanel filter2Panel = new JPanel();
			filter1Panel.add(OposTeam);
			filter2Panel.add(Specialization);
			filter1Panel.add(filter1);
			filter2Panel.add(filter2);
			playerinfo.add(filter2Panel, BorderLayout.SOUTH);
			gameinfo.add(filter1Panel, BorderLayout.SOUTH);
			undoSelected1 = new JButton("Deselect");
			undoSelected2 = new JButton("Deselect");
				
			filter1Panel.add(undoSelected1, BorderLayout.SOUTH);
			filter2Panel.add(undoSelected2, BorderLayout.SOUTH);
			filter2Panel.add(new JLabel("Легенда: M - Матчей, GIB - Игр в основе, G - Голы, CONS - Пропущено голов, MS - Ударов мимо"), BorderLayout.EAST);
			gameinfo.setVisible(true);
			
			Players.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					teams.setVisible(false);
					gameinfo.setVisible(false);
					playerinfo.setVisible(true);
				}
			});
			Games.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sps.setVisible(false);
					gameinfo.setVisible(true);
					playerinfo.setVisible(false); 
				}
			});
			delete_el1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MyExceptionforArray.checkLen(len1);
						int result = JOptionPane.showConfirmDialog(gameinfo,
							"Вы уверены что хотите удалить?",
							"Подтверждение удаления",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
							if (games.getSelectedRowCount() > 0) {
								int[] selectedRows = games.getSelectedRows();
								for (int i = 0; i < selectedRows.length; i++) {
									model1.removeRow(selectedRows[i] - i);
								}
								for (int i = 0; i < selectedRows.length; i++) {
									for (int j = selectedRows[i] - i; j < len1; j++) {
										if (j == len1 - 1) {
											data1[j] = null;
										}
										else {
											data1[j] = data1[j + 1];
										}
									}
									len1 = len1 - 1;
								}
							}
							else {
								model1.removeRow(len1 - 1);
								data1[len1 - 1] = null;
								len1 = len1 - 1;
							}
							num_of_games.setText(String.valueOf(len1));
							status1.setText("UNSAVED");
						}
					}
					catch(NullPointerException Ex) {
						JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
					}
					catch(MyExceptionforArray myEx) {
						JOptionPane.showMessageDialog(null, myEx.getMessage());
					}
				}
			});
			delete_el2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						MyExceptionforArray.checkLen(len2);
						int result = JOptionPane.showConfirmDialog(gameinfo,
							"Вы уверены что хотите удалить?",
							"Подтверждение удаления",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
							if (players.getSelectedRowCount() > 0) {
								int[] selectedRows = players.getSelectedRows();
								for (int i = 0; i < selectedRows.length; i++) {
									model2.removeRow(selectedRows[i] - i);
								}
								for (int i = 0; i < selectedRows.length; i++) {
									for (int j = selectedRows[i] - i; j < len2; j++) {
										if (j == len2 - 1) {
											data2[j] = null;
										}
										else {
											data2[j] = data2[j + 1];
										}
									}
									len2 = len2 - 1;
								}
							}
							else {
								model2.removeRow(len2 - 1);
								data2[len2 - 1] = null;
								len2 = len2 - 1;
							}
							status2.setText("UNSAVED");
						}
					}
					catch(NullPointerException Ex) {
						JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
					}
					catch(MyExceptionforArray myEx) {
						JOptionPane.showMessageDialog(null, myEx.getMessage());
					}
					
				}
			});
			Report_PDF1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (status1.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo,
							"Вы не сохранили данные, вы уверены что хотите сохранить всё в PDF-FILE?",
							"Подтверждение сохранения",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
								try {
									ReportGenerator generator = new ReportGenerator();
									generator.generateReport("Game.jrxml", "games.pdf");
									JOptionPane.showMessageDialog(null, "PDF-файл games.pdf успешно сохранен.");
									
								} catch (Exception E) {
									E.printStackTrace();
								}
								break;
						}
					}
					else {
						try {
							ReportGenerator generator = new ReportGenerator();
							generator.generateReport("Game.jrxml", "games.pdf");
							JOptionPane.showMessageDialog(null, "PDF-файл games.pdf успешно сохранен.");
							
						} catch (Exception E) {
							E.printStackTrace();
						}
					}
				}
			});
			Report_PDF2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo,
							"Вы не сохранили данные, вы уверены что хотите сохранить всё в PDF-FILE?",
							"Подтверждение сохранения",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
								try {
									ReportGenerator generator = new ReportGenerator();
									generator.generateReport("Player.jrxml", "players.pdf");
									JOptionPane.showMessageDialog(null, "PDF-файл players.pdf успешно сохранен.");
									
								} catch (Exception E) {
									E.printStackTrace();
								}
								break;
						}
					}
					else {
						try {
							ReportGenerator generator = new ReportGenerator();
							generator.generateReport("Player.jrxml", "players.pdf");
							JOptionPane.showMessageDialog(null, "PDF-файл players.pdf успешно сохранен.");
							
						} catch (Exception E) {
							E.printStackTrace();
						}
					}
				}
			});
			Report_Xml1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (status1.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo,
							"Вы не сохранили данные, вы уверены что хотите сохранить всё в XML-FILE?",
							"Подтверждение создания",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
								try {
									new MySQLToXML().convert("test_persistence", "gm");
									JOptionPane.showMessageDialog(null, "XML-файл games.xml успешно сохранен.");
								} 
								catch (Exception E) {
									E.printStackTrace();
								}
								break;
						}
					}
					else {
						try {
							new MySQLToXML().convert("test_persistence", "gm");
							JOptionPane.showMessageDialog(null, "XML-файл games.xml успешно сохранен.");
						} 
						catch (Exception E) {
							E.printStackTrace();
						}
					}
				}
			});
			Report_Xml2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(playerinfo,
							"Вы не сохранили данные, вы уверены что хотите сохранить всё в XML-FILE?",
							"Подтверждение создания",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						switch (result) {
							case JOptionPane.YES_OPTION:
								try {
									new MySQLToXML().convert("test_persistence", "pl");
									JOptionPane.showMessageDialog(null, "XML-файл players.xml успешно сохранен.");
								} 
								catch (Exception E) {
									E.printStackTrace();
								}
								break;
						}
					}
					else {
						try {
							new MySQLToXML().convert("test_persistence", "pl");
							JOptionPane.showMessageDialog(null, "XML-файл players.xml успешно сохранен.");
						} 
						catch (Exception E) {
							E.printStackTrace();
						}
					}
				}
			});
			filter1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					games.clearSelection();
					for (int row = 0; row < model1.getRowCount(); row++) {
						String cellValue = model1.getValueAt(row, 1).toString();
						if (cellValue == ((String) OposTeam.getSelectedItem())) {
							games.addRowSelectionInterval(row, row);
						}
					}
				}
			});
			filter2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					players.clearSelection();
					for (int row = 0; row < model2.getRowCount(); row++) {
						String cellValue = model2.getValueAt(row, 3).toString();
						if (cellValue == ((String) Specialization.getSelectedItem())) {
							players.addRowSelectionInterval(row, row);
						}
					}
				}
			});
			save1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean empty = false;
					for (int i = 0; i < len1; i++) {
						for (int j = 0; j < 5; j++) {
							if (data1[i][j].equals("") == true) {
								empty = true;
							}
						}
					}
					if (empty) { 
						JOptionPane.showMessageDialog(gameinfo, "В таблице остались пустые ячейки");
					}
					else {
						status1.setText("SAVED");;
						EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_persistence");
						EntityManager em = emf.createEntityManager();
						em.getTransaction().begin();
						try {
							em.createQuery("DELETE FROM Game").executeUpdate();
							for (int i = 0; i < len1; i++) {
								Game newdata = new Game();
								newdata.SetGId(Integer.valueOf(data1[i][0]));
								newdata.SetOpositeTeam(from_ot_to_id(data1[i][1], OposTeamS));
								newdata.SetFirstScore(Integer.valueOf(data1[i][2]));
								newdata.SetSecondScore(Integer.valueOf(data1[i][3]));
								newdata.SetDate(data1[i][4]);
								em.persist(newdata);
							}
							em.getTransaction().commit();

						} 
						catch (Exception ex) {
							em.getTransaction().rollback();
							System.err.println("Ошибка при обновлении данных: " + ex.getMessage());
						} 
						finally {
							em.close();
						}
					}
				}
			});
			save2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean empty = false;
					for (int i = 0; i < len2; i++) {
						for (int j = 0; j < 4; j++) {
							if (data2[i][j].equals("") == true) {
								empty = true;
							}
						}
					}
					if (empty) { 
						JOptionPane.showMessageDialog(playerinfo, "В таблице остались пустые ячейки");
					}
					else {
						status2.setText("SAVED");
						EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_persistence");
						EntityManager em = emf.createEntityManager();
						em.getTransaction().begin();
						try {
							em.createQuery("DELETE FROM Player").executeUpdate();
							for (int i = 0; i < len2; i++) {
								Player newdata = new Player();
								newdata.SetPlId(Integer.valueOf(data2[i][0]));
								newdata.setPlayerName(data2[i][1]);
								newdata.setResult(data2[i][2]);
								newdata.setspecial(from_spec_to_id(data2[i][3], SpecializationS));
								em.persist(newdata);
							}
							em.getTransaction().commit();

						} 
						catch (Exception ex) {
							em.getTransaction().rollback();
							System.err.println("Ошибка при обновлении данных: " + ex.getMessage());
						} 
						finally {
							em.close();
						}
					}
				}
			});
			add_el1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					status1.setText("UNSAVED");
					model1.addRow(new String[] {String.valueOf(len1 + 1), "", "", "", ""});
					String[][] newdata = new String[len1][5];
					newdata = data1.clone();
					data1 = new String[len1 + 1][5];
					System.arraycopy(newdata, 0, data1, 0, len1);
					len1 = len1 + 1;
					num_of_games.setText(String.valueOf(len1));
					data1[len1 - 1] = new String[]{String.valueOf(len1), "", "", "", ""};
				}
			});
			add_el2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					status2.setText("UNSAVED");
					model2.addRow(new String[] {String.valueOf(len2 + 1), "", "", ""});
					String[][] newdata = new String[len2][4];
					newdata = data2.clone();
					data2 = new String[len2 + 1][4];
					System.arraycopy(newdata, 0, data2, 0, len2);
					len2 = len2 + 1;
					data2[len2 - 1] = new String[]{String.valueOf(len2), "", "", ""};
				}
			});
			undoSelected1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					games.clearSelection();
				}
			});
			undoSelected2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					players.clearSelection();
				}	
			});
			model1.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					if (e.getColumn() == 0) {
						try {
							MyExceptionforNum.checkNumber(games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							data1[e.getFirstRow()][e.getColumn()] = (games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status1.setText("UNSAVED");
						}
						catch(NullPointerException Ex) {
							JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
						}
						catch(MyExceptionforNum myEx) {
							JOptionPane.showMessageDialog(gameinfo, myEx.getMessage());
							model1.setValueAt(data1[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					else if (e.getColumn() == 1) {
						try {
							MyExceptionforOT.checkOT(games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString(), OposTeamS);
							data1[e.getFirstRow()][e.getColumn()] = (games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status1.setText("UNSAVED");
						}
						catch (NullPointerException ex) {
							JOptionPane.showMessageDialog(gameinfo, ex.getMessage());
						}
						catch (MyExceptionforOT myEx) {
							JOptionPane.showMessageDialog(gameinfo, myEx.getMessage());
							model1.setValueAt(data1[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					else if (e.getColumn() == 2) {
						try {
							MyExceptionforScore.checkNumber(games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							data1[e.getFirstRow()][e.getColumn()] = (games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status1.setText("UNSAVED");
						}
						catch(NullPointerException Ex) {
							JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
						}
						catch(MyExceptionforScore myEx) {
							JOptionPane.showMessageDialog(gameinfo, myEx.getMessage());
							model1.setValueAt(data1[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					else if (e.getColumn() == 3) {
						try {
							MyExceptionforScore.checkNumber(games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							data1[e.getFirstRow()][e.getColumn()] = (games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status1.setText("UNSAVED");
						}
						catch(NullPointerException Ex) {
							JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
						}
						catch(MyExceptionforScore myEx) {
							JOptionPane.showMessageDialog(gameinfo, myEx.getMessage());
							model1.setValueAt(data1[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					else if (e.getColumn() == 4) {
						try {
							MyExceptionforDate.checkDate(games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString(), data1, e.getFirstRow());
							data1[e.getFirstRow()][e.getColumn()] = (games.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status1.setText("UNSAVED");
						}
						catch(NullPointerException Ex) {
							JOptionPane.showMessageDialog(gameinfo, Ex.getMessage());
						}
						catch (MyExceptionforDate myEx) {
							JOptionPane.showMessageDialog(gameinfo, myEx.getMessage());
							model1.setValueAt(data1[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
				} 
			});
			model2.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					if (e.getColumn() == 0) {
						try {
							MyExceptionforNum.checkNumber(players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							data2[e.getFirstRow()][e.getColumn()] = (players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status2.setText("UNSAVED");
						}
						catch(NullPointerException Ex) {
							JOptionPane.showMessageDialog(players, Ex.getMessage());
						}
						catch(MyExceptionforNum myEx) {
							JOptionPane.showMessageDialog(players, myEx.getMessage());
							model2.setValueAt(data2[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					else if (e.getColumn() == 1) {
						try {
							MyExceptionforName.checkName(players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							data2[e.getFirstRow()][e.getColumn()] = (players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status2.setText("UNSAVED");
						}
						catch (MyExceptionforName myEx){
							JOptionPane.showMessageDialog(playerinfo, myEx.getMessage());
							model2.setValueAt(data2[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
						catch (NullPointerException Ex) {
							JOptionPane.showMessageDialog(playerinfo, Ex.getMessage());
						}
					}
					else if (e.getColumn() == 2) {
						if ((players.getModel().getValueAt(e.getFirstRow(), 3).toString()).equals("Goalkeeper") ) {
							try {
								MyExceptionforGKRes.checkGKRes(players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
								data2[e.getFirstRow()][e.getColumn()] = (players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
								status2.setText("UNSAVED");
							}
							catch (NullPointerException Ex) {
								JOptionPane.showMessageDialog(playerinfo, Ex.getMessage());
							}
							catch (MyExceptionforGKRes myEx) {
								JOptionPane.showMessageDialog(playerinfo, myEx.getMessage());
								model2.setValueAt(data2[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
							}
						}
						else {
							try {
								MyExceptionforFlRes.checkFlRes(players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
								data2[e.getFirstRow()][e.getColumn()] = (players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
								status2.setText("UNSAVED");
							}
							catch (NullPointerException Ex) {
								JOptionPane.showMessageDialog(playerinfo, Ex.getMessage());
							}
							catch (MyExceptionforFlRes myEx) {
								JOptionPane.showMessageDialog(playerinfo, myEx.getMessage());
								model2.setValueAt(data2[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
							}
						}
					}
					else if (e.getColumn() == 3) {
						try {
							MyExceptionforSp.checkSp(players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString(), SpecializationS);
							data2[e.getFirstRow()][e.getColumn()] = (players.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
							status2.setText("UNSAVED");
						}
						catch (NullPointerException Ex) {
							JOptionPane.showMessageDialog(playerinfo, Ex.getMessage());
						}
						catch (MyExceptionforSp myEx) {
							JOptionPane.showMessageDialog(playerinfo, myEx.getMessage());
							model2.setValueAt(data2[e.getFirstRow()][e.getColumn()], e.getFirstRow(), e.getColumn());
						}
					}
					
				}
			});
			games.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					
					JTable table = (JTable)e.getSource();
					int column = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					if (column == 1 && e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
						
						table.setRowSelectionInterval(row, row);
						
						teams.setVisible(false);
						teams = new JFrame("List of teams");
						teams.setAlwaysOnTop(true);
						teams.setSize(80, 310);
						teams.setLayout(new BorderLayout());
						String[][] data = new String[OposTeamS.length - 1][1];
						int k = 0;
						for (String i : OposTeamS) {
							if (k > 0) {
								data[k - 1][0] = i;
							}
							k++;
						}
						DefaultTableModel model = new DefaultTableModel(data, new String[] {"List of teams"});
						JTable table2 = new JTable(model);
						JScrollPane scroll = new JScrollPane(table2);
						teams.add(scroll, BorderLayout.CENTER);
						teams.setVisible(true);
						table2.addMouseListener(new MouseListener() {
							public void mouseClicked(MouseEvent eg) {
								JTable t = (JTable)eg.getSource();
								int r = t.rowAtPoint(eg.getPoint());
								model1.setValueAt(data[r][0], row, 1);
								status1.setText("UNSAVED");
								teams.setVisible(false);
								data1[row][1] = data[r][0];
							}
						
							public void mouseExited(MouseEvent eg) {}
							public void mouseReleased(MouseEvent eg) {}
							public void mousePressed(MouseEvent eg) {}
							public void mouseEntered(MouseEvent eg) {}
						});
					}
				}
				public void mouseExited(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
			});
			players.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					
					JTable table = (JTable)e.getSource();
					int column = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					
					if (column == 3 && e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
						table.setRowSelectionInterval(row, row);
						
						sps.setVisible(false);
						sps = new JFrame("List of teams");
						sps.setAlwaysOnTop(true);
						sps.setSize(80, 150);
						sps.setLayout(new BorderLayout());
						String[][] data = new String[SpecializationS.length - 1][1];
						int k = 0;
						for (String i : SpecializationS) {
							if (k > 0) {
								data[k - 1][0] = i;
								
							}
							k++;
						}
						DefaultTableModel model = new DefaultTableModel(data, new String[] {"List of specializations"});
						JTable table2 = new JTable(model);
						JScrollPane scroll = new JScrollPane(table2);
						sps.add(scroll, BorderLayout.CENTER);
						sps.setVisible(true);
						table2.addMouseListener(new MouseListener() {
							public void mouseClicked(MouseEvent eg) {
								JTable t = (JTable)eg.getSource();
								int r = t.rowAtPoint(eg.getPoint());
								
								
								if ((data[r][0].equals("Goalkeeper") == true) && (data2[row][3].equals("Goalkeeper") == false)) {
									model2.setValueAt(data[r][0], row, 3);
									status2.setText("UNSAVED");
									sps.setVisible(false);
									data2[row][3] = data[r][0];
									model2.setValueAt("M:00 GIB:00 CONS:00", row, 2);
									data2[row][2] = "M:00 GIB:00 CONS:00";
								}
								else if ((data[r][0].equals("Goalkeeper") == false) && (data2[row][3].equals("Goalkeeper") == true)) {
									model2.setValueAt(data[r][0], row, 3);
									status2.setText("UNSAVED");
									sps.setVisible(false);
									data2[row][3] = data[r][0];
									model2.setValueAt("M:00 GIB:00 G:00 MS:00", row, 2);
									data2[row][2] = "M:00 GIB:00 M:00 MS:00";
								}
								else {
									model2.setValueAt(data[r][0], row, 3);
									status2.setText("UNSAVED");
									sps.setVisible(false);
									data2[row][3] = data[r][0];
								}
								
								
							}
							public void mouseExited(MouseEvent eg) {}
							public void mouseReleased(MouseEvent eg) {}
							public void mousePressed(MouseEvent eg) {}
							public void mouseEntered(MouseEvent eg) {}
						});
					}
				}
				public void mouseExited(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
			});
			gameinfo.addWindowListener(new WindowAdapter() {
				@Override 
				public void windowClosing(WindowEvent e) {
					if (status1.getText() == "UNSAVED" && status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo, "Вы не сохранили данные об игроках и играх. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							gameinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "UNSAVED" && status2.getText() == "SAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo, "Вы не сохранили данные об играх. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							gameinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "SAVED" && status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(gameinfo, "Вы не сохранили данные об игроках. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							gameinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "SAVED" && status2.getText() == "SAVED") {
						gameinfo.dispose();
						System.exit(0);
					}
				}
			});
			playerinfo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					if (status1.getText() == "UNSAVED" && status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(playerinfo, "Вы не сохранили данные об игроках и играх. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							playerinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "UNSAVED" && status2.getText() == "SAVED") {
						int result = JOptionPane.showConfirmDialog(playerinfo, "Вы не сохранили данные об играх. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							playerinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "SAVED" && status2.getText() == "UNSAVED") {
						int result = JOptionPane.showConfirmDialog(playerinfo, "Вы не сохранили данные об игроках. Вы уверены, что хотите закрыть окно?", "Подтверждение закрытия", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							playerinfo.dispose();
							System.exit(0);
						}
					}
					else if (status1.getText() == "SAVED" && status2.getText() == "SAVED") {
						playerinfo.dispose();
						System.exit(0);
					}
				}
			});
			logger.info("GUI has been initialized successfully\n");
		}
		catch (Exception e) {
			logger.error("GUI initialization error\n", e);
		}
	} 
}