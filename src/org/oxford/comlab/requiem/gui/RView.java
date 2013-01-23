package org.oxford.comlab.requiem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.oxford.comlab.requiem.rewriter.Clause;

public class RView {
	
	private static final RModel m_model = new RModel();  //  @jve:decl-index=0:
	String ontologyPath = "";  //  @jve:decl-index=0:
	String mappingsPath = "";  //  @jve:decl-index=0:
	String query = "";  //  @jve:decl-index=0:
	String[] databaseConnectionData = new String[]{"","","",""};
	ArrayList<Clause> rewriting = null;
	
	private JFrame jFrame = null;
	private JDialog aboutDialog = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JPanel ontologyPanel = null;
	private JPanel jPanel5 = null;
	private JButton jButton = null;
	private JPanel jPanel = null;
	private JLabel jLabel10 = null;
	private JTextField databaseURL = null;
	private JLabel jLabel11 = null;
	private JTextField databaseName = null;
	private JLabel jLabel12 = null;
	private JTextField username = null;
	private JLabel jLabel13 = null;
	private JPasswordField password = null;
	private JPanel DBPanel = null;
	private JPanel queryPanel = null;
	private JScrollPane jScrollPane1 = null;
	private JPanel rewritingPanel = null;
	private JScrollPane jScrollPane2 = null;
	private JTextArea rewritingTextArea = null;
	private JPanel jPanel1 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JFileChooser jFileChooser = null;
	private JTextField ontologyTextField = null;
	private JTextArea queryTextArea = null;
	private JOptionPane jOptionPane = null;
	private JPanel jPanel9 = null;
	private JPanel jPanel10 = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenu jMenu2 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem jMenuItem7 = null;
	private JPanel SQLPanel = null;
	private JScrollPane jScrollPane21 = null;
	private JTextArea SQLTextArea = null;
	private JSplitPane jSplitPane = null;
	private JSplitPane jSplitPane1 = null;
	private JPanel answerPanel = null;
	private JScrollPane jScrollPane22 = null;
	private JTextArea answerTextArea = null;
	private JMenu jMenu4 = null;
	private JMenuItem jMenuItem8 = null;
	private JSeparator jSeparator = null;
	private JPanel mappingsPanel = null;
	private JPanel jPanel51 = null;
	private JButton jButton1 = null;
	private JTextField mappingsTextField = null;
	private JPanel jPanel6 = null;
	private JPanel jPanel7 = null;
	
	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(1000, 700);
			jFrame.setContentPane(getJPanel9());
			jFrame.setJMenuBar(getJJMenuBar());
		}
		return jFrame;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes ontologyPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getOntologyPanel() {
		if (ontologyPanel == null) {
			ontologyPanel = new JPanel();
			ontologyPanel.setLayout(new BorderLayout());
			ontologyPanel.setName("");
			ontologyPanel.setBorder(BorderFactory.createTitledBorder(null, "Ontology", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			ontologyPanel.setPreferredSize(new Dimension(820, 57));
			ontologyPanel.add(getJPanel5(), BorderLayout.EAST);
			ontologyPanel.add(getOntologyTextField(), BorderLayout.CENTER);
		}
		return ontologyPanel;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(new BorderLayout());
			jPanel5.add(getJButton(), BorderLayout.EAST);
		}
		return jPanel5;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Choose...");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					ExtensionFileFilter filter = new ExtensionFileFilter();
					filter.addExtension("owl", false);
					filter.setDescription("OWL files");
				    jFileChooser.setFileFilter(filter);
					
					int value = jFileChooser.showOpenDialog(jFrame);
			
					if(value == JFileChooser.APPROVE_OPTION){
						ontologyPath = jFileChooser.getSelectedFile().getAbsolutePath();
						ontologyTextField.setText(ontologyPath);
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("\tPassword:");
			jLabel13.setPreferredSize(new Dimension(51, 16));
			jLabel12 = new JLabel();
			jLabel12.setText("\tUsername:");
			jLabel12.setPreferredSize(new Dimension(51, 16));
			jLabel11 = new JLabel();
			jLabel11.setText("\tDatabase name:");
			jLabel11.setPreferredSize(new Dimension(51, 16));
			jLabel10 = new JLabel();
			jLabel10.setText("\tDBMS URL:");
			jLabel10.setPreferredSize(new Dimension(51, 16));
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setColumns(2);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout1);
			jPanel.add(jLabel10, null);
			jPanel.add(getDatabaseURL(), null);
			jPanel.add(jLabel11, null);
			jPanel.add(getDatabaseName(), null);
			jPanel.add(jLabel12, null);
			jPanel.add(getUsername(), null);
			jPanel.add(jLabel13, null);
			jPanel.add(getPassword(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes databaseURL	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDatabaseURL() {
		if (databaseURL == null) {
			databaseURL = new JTextField();
			databaseURL.setText("jdbc:postgresql://localhost:5432/");
		}
		return databaseURL;
	}

	/**
	 * This method initializes databaseName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDatabaseName() {
		if (databaseName == null) {
			databaseName = new JTextField();
			databaseName.setText("wn_jpn_postgresql");
		}
		return databaseName;
	}

	/**
	 * This method initializes username	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUsername() {
		if (username == null) {
			username = new JTextField();
			username.setText("postgres");
		}
		return username;
	}

	/**
	 * This method initializes password	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setText("820827");
		}
		return password;
	}

	/**
	 * This method initializes DBPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getDBPanel() {
		if (DBPanel == null) {
			DBPanel = new JPanel();
			DBPanel.setLayout(new BorderLayout());
			DBPanel.setBorder(BorderFactory.createTitledBorder(null, "Database Settings", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			DBPanel.setPreferredSize(new Dimension(274, 140));
			DBPanel.add(getJPanel(), BorderLayout.NORTH);
		}
		return DBPanel;
	}

	/**
	 * This method initializes queryPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getQueryPanel() {
		if (queryPanel == null) {
			queryPanel = new JPanel();
			queryPanel.setLayout(new BorderLayout());
			queryPanel.setBorder(BorderFactory.createTitledBorder(null, "Query", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			queryPanel.add(getJScrollPane1(), BorderLayout.CENTER);
		}
		return queryPanel;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setPreferredSize(new Dimension(145, 100));
			jScrollPane1.setViewportView(getQueryTextArea());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes rewritingPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getRewritingPanel() {
		if (rewritingPanel == null) {
			rewritingPanel = new JPanel();
			rewritingPanel.setLayout(new BorderLayout());
			rewritingPanel.setBorder(BorderFactory.createTitledBorder(null, "Rewriting", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida Grande", Font.PLAIN, 13), Color.black));
			rewritingPanel.add(getJScrollPane2(), BorderLayout.CENTER);
		}
		return rewritingPanel;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getRewritingTextArea());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes rewritingTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getRewritingTextArea() {
		if (rewritingTextArea == null) {
			rewritingTextArea = new JTextArea();
			rewritingTextArea.setEditable(false);
			rewritingTextArea.setEnabled(true);
		}
		return rewritingTextArea;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJButton3(), new GridBagConstraints());
			jPanel1.add(getJButton4(), gridBagConstraints);
			jPanel1.add(getJButton5(), gridBagConstraints1);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Rewrite");
			jButton3.setPreferredSize(new Dimension(99, 29));
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {			
					//Rewrite query
					
						rewritingTextArea.setText("");
						SQLTextArea.setText("");
						answerTextArea.setText("");

						query = queryTextArea.getText().trim();
						ontologyPath = ontologyTextField.getText().trim();
						
						if(ontologyPath.indexOf("/") == 0){
							ontologyPath = "file://" + ontologyPath;
						}

						try{
							jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
							long begin = System.currentTimeMillis();
							rewriting = m_model.rewriteQuery(query, ontologyPath);
							long end = System.currentTimeMillis();
							Collections.sort(rewriting, new Comparator<Clause>(){
								public int compare(Clause c1, Clause c2){
								    return c1.m_canonicalRepresentation.compareTo(c2.m_canonicalRepresentation);
								}
							});

							for(Clause c:rewriting){
								rewritingTextArea.append(c.toString()+"\n");
							}
							
							int size = 0;
							for(Clause c: rewriting){
								size += c.toString().length();
							}
							
							rewritingTextArea.append("-------------------------------\n");
					        if(rewriting.size() == 1){
					        	rewritingTextArea.append("1 CQ (" + size + " symbols) in " + Long.toString(end - begin) + " millisec.");
					        }
					        else{
					        	rewritingTextArea.append(rewriting.size() + " CQs (" + size + " symbols) in " + Long.toString(end - begin) + " millisec.");
					        }
					        
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
							ontologyPath = "";
							query = "";
						}
						finally{
							jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						}
				}

			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("SQLify");
			jButton4.setPreferredSize(new Dimension(99, 29));
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButton3.doClick();
						mappingsPath = mappingsTextField.getText().trim();
						SQLTextArea.setText("");
						answerTextArea.setText("");
						try {
							jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
							String SQLQuery = m_model.getSQLQuery(mappingsPath, rewriting);
							if(SQLQuery == null){
								jOptionPane = getJOptionPane();
								JOptionPane.showMessageDialog(jFrame,
									    "Rewriting is not a UCQs.",
									    "Warning",
									    JOptionPane.INFORMATION_MESSAGE);
							}
							else if(SQLQuery.equals("")){
								jOptionPane = getJOptionPane();
								JOptionPane.showMessageDialog(jFrame,
									    "Empty SQL query (not enough mappings).",
									    "Warning",
									    JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								SQLTextArea.setText(SQLQuery);
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} finally{
							jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						}
					}
			});
		}
		return jButton4;
	}
	
	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("Evaluate");
			jButton5.setPreferredSize(new Dimension(99, 29));
			jButton5.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButton4.doClick();
						answerTextArea.setText("");
						jFrame.paint(jFrame.getGraphics());
						if(!SQLTextArea.getText().trim().equals("")){
							new Thread() {  
								public void run(){  
									try {
										databaseConnectionData[0] = databaseURL.getText().trim();
										databaseConnectionData[1] = databaseName.getText().trim();
										databaseConnectionData[2] = username.getText().trim();
										databaseConnectionData[3] = (new String(password.getPassword())).trim();
										jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
										m_model.evaluateSQLQuery(databaseConnectionData, SQLTextArea.getText().trim(), answerTextArea);	  
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										jOptionPane = getJOptionPane();
										JOptionPane.showMessageDialog(jFrame,
											    e1.toString(),
											    "Error",
											    JOptionPane.ERROR_MESSAGE);
										e1.printStackTrace();
									}finally{
										jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
									}
								}
							}.start();
						}						
					}
				
			});
		}
		return jButton5;
	}

	/**
	 * This method initializes jFileChooser	
	 * 	
	 * @return javax.swing.JFileChooser	
	 */
	private JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new JFileChooser();
		}
		return jFileChooser;
	}

	/**
	 * This method initializes ontologyTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOntologyTextField() {
		if (ontologyTextField == null) {
			ontologyTextField = new JTextField();
			ontologyTextField.setText("/Users/hekanibru/Documents/DPhil/Prototype/Tokyo/JapaneseWordNet/wnfull_modified_japanese.owl");
			ontologyTextField.setPreferredSize(new Dimension(709, 28));
		}
		return ontologyTextField;
	}

	/**
	 * This method initializes queryTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getQueryTextArea() {
		if (queryTextArea == null) {
			queryTextArea = new JTextArea();
			queryTextArea.setText("Q(?0,?3) <- containsWordSense(?0,?1), word(?1,?2), lexicalForm(?2,\"bank\"), gloss(?0,?3)");
		}
		return queryTextArea;
	}

	/**
	 * This method initializes jOptionPane	
	 * 	
	 * @return javax.swing.JOptionPane	
	 */
	private JOptionPane getJOptionPane() {
		if (jOptionPane == null) {
			jOptionPane = new JOptionPane();
			jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
			jOptionPane.setMessage("");
		}
		return jOptionPane;
	}

	/**
	 * This method initializes jPanel9	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jPanel9 = new JPanel();
			jPanel9.setLayout(new BorderLayout());
			jPanel9.setPreferredSize(new Dimension(1594, 384));
			jPanel9.add(getJSplitPane1(), BorderLayout.CENTER);
			jPanel9.add(getJPanel6(), BorderLayout.NORTH);
		}
		return jPanel9;
	}

	/**
	 * This method initializes jPanel10	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel10() {
		if (jPanel10 == null) {
			jPanel10 = new JPanel();
			jPanel10.setLayout(new BorderLayout());
			jPanel10.add(getQueryPanel(), BorderLayout.CENTER);
			jPanel10.add(getOntologyPanel(), BorderLayout.NORTH);
			jPanel10.add(getMappingsPanel(), BorderLayout.SOUTH);
		}
		return jPanel10;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("REQUIEM");
			jMenu.add(getJMenuItem());
			jMenu.add(getJSeparator());
			jMenu.add(getJMenuItem1());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("About");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Quit");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu4());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Query");
			jMenu1.add(getJMenuItem2());
			jMenu1.add(getJMenuItem3());
		}
		return jMenu1;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Open File...");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					ExtensionFileFilter filter = new ExtensionFileFilter();
					filter.addExtension("txt", false);
					filter.setDescription("Text files");
				    jFileChooser.setFileFilter(filter);
					
					int value = jFileChooser.showOpenDialog(jFrame);
					
					if(value == JFileChooser.APPROVE_OPTION){
						//Load mappings
						queryTextArea.setText("");
						try {
							queryTextArea.setText(m_model.loadFile(jFileChooser.getSelectedFile()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						
						}
					}
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Save As...");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					int returnValue = jFileChooser.showSaveDialog(jFrame);
					if(returnValue == JFileChooser.APPROVE_OPTION){
						
						try {
							m_model.saveFile(jFileChooser.getSelectedFile(), queryTextArea.getText());							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);

							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jMenuItem3;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Rewriting");
			jMenu2.add(getJMenuItem4());
			jMenu2.add(getJMenuItem7());
		}
		return jMenu2;
	}

	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Save Rewriting As...");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					int returnValue = jFileChooser.showSaveDialog(jFrame);
					if(returnValue == JFileChooser.APPROVE_OPTION){
						try {
							m_model.saveFile(jFileChooser.getSelectedFile(), rewritingTextArea.getText());							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);

							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jMenuItem4;
	}

	/**
	 * This method initializes jMenuItem7	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Save SQL As...");
			jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					int returnValue = jFileChooser.showSaveDialog(jFrame);
					if(returnValue == JFileChooser.APPROVE_OPTION){
						try {
							m_model.saveFile(jFileChooser.getSelectedFile(), SQLTextArea.getText());							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);

							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jMenuItem7;
	}

	/**
	 * This method initializes SQLPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getSQLPanel() {
		if (SQLPanel == null) {
			SQLPanel = new JPanel();
			SQLPanel.setLayout(new BorderLayout());
			SQLPanel.setBorder(BorderFactory.createTitledBorder(null, "SQL", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida Grande", Font.PLAIN, 13), Color.black));
			SQLPanel.add(getJScrollPane21(), java.awt.BorderLayout.CENTER);
		}
		return SQLPanel;
	}

	/**
	 * This method initializes jScrollPane21	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane21() {
		if (jScrollPane21 == null) {
			jScrollPane21 = new JScrollPane();
			jScrollPane21.setViewportView(getSQLTextArea());
		}
		return jScrollPane21;
	}

	/**
	 * This method initializes SQLTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getSQLTextArea() {
		if (SQLTextArea == null) {
			SQLTextArea = new JTextArea();
			SQLTextArea.setEnabled(true);
			SQLTextArea.setEditable(false);
		}
		return SQLTextArea;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane.setBottomComponent(getSQLPanel());
			jSplitPane.setTopComponent(getRewritingPanel());
			jSplitPane.setResizeWeight(0.5);

		}
		return jSplitPane;
	}

	/**
	 * This method initializes jSplitPane1	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane1() {
		if (jSplitPane1 == null) {
			jSplitPane1 = new JSplitPane();
			jSplitPane1.setDividerLocation(500);
			jSplitPane1.setPreferredSize(new Dimension(1094, 113));
			jSplitPane1.setLeftComponent(getJSplitPane());
			jSplitPane1.setRightComponent(getAnswerPanel());
			jSplitPane1.setResizeWeight(0.5);
		}
		return jSplitPane1;
	}

	/**
	 * This method initializes answerPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getAnswerPanel() {
		if (answerPanel == null) {
			answerPanel = new JPanel();
			answerPanel.setLayout(new BorderLayout());
			answerPanel.setBorder(BorderFactory.createTitledBorder(null, "Answer", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida Grande", Font.PLAIN, 13), Color.black));
			answerPanel.add(getJScrollPane22(), java.awt.BorderLayout.CENTER);
		}
		return answerPanel;
	}

	/**
	 * This method initializes jScrollPane22	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane22() {
		if (jScrollPane22 == null) {
			jScrollPane22 = new JScrollPane();
			jScrollPane22.setViewportView(getAnswerTextArea());
		}
		return jScrollPane22;
	}

	/**
	 * This method initializes answerTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAnswerTextArea() {
		if (answerTextArea == null) {
			answerTextArea = new JTextArea();
			answerTextArea.setEnabled(true);
			answerTextArea.setEditable(false);
		}
		return answerTextArea;
	}

	/**
	 * This method initializes jMenu4	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu4() {
		if (jMenu4 == null) {
			jMenu4 = new JMenu();
			jMenu4.setText("Answer");
			jMenu4.add(getJMenuItem8());
		}
		return jMenu4;
	}

	/**
	 * This method initializes jMenuItem8	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Save As...");
			jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					int returnValue = jFileChooser.showSaveDialog(jFrame);
					if(returnValue == JFileChooser.APPROVE_OPTION){
						try {
							m_model.saveFile(jFileChooser.getSelectedFile(), answerTextArea.getText());							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							jOptionPane = getJOptionPane();
							JOptionPane.showMessageDialog(jFrame,
								    e1.toString(),
								    "Error",
								    JOptionPane.ERROR_MESSAGE);

							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jMenuItem8;
	}

	/**
	 * This method initializes jSeparator	
	 * 	
	 * @return javax.swing.JSeparator	
	 */
	private JSeparator getJSeparator() {
		if (jSeparator == null) {
			jSeparator = new JSeparator();
		}
		return jSeparator;
	}

	/**
	 * Launches this application
	 */
	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				RView application = new RView();
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes mappingsPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getMappingsPanel() {
		if (mappingsPanel == null) {
			mappingsPanel = new JPanel();
			mappingsPanel.setLayout(new BorderLayout());
			mappingsPanel.setName("");
			mappingsPanel.setBorder(BorderFactory.createTitledBorder(null, "Mappings", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida Grande", Font.PLAIN, 13), Color.black));
			mappingsPanel.add(getJPanel51(), java.awt.BorderLayout.EAST);
			mappingsPanel.add(getMappingsTextField(), java.awt.BorderLayout.CENTER);
		}
		return mappingsPanel;
	}

	/**
	 * This method initializes jPanel51	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel51() {
		if (jPanel51 == null) {
			jPanel51 = new JPanel();
			jPanel51.setLayout(new BorderLayout());
			jPanel51.add(getJButton1(), java.awt.BorderLayout.EAST);
		}
		return jPanel51;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Choose...");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFileChooser = null;
					jFileChooser = getJFileChooser();
					
					ExtensionFileFilter filter = new ExtensionFileFilter();
					filter.addExtension("txt", false);
					filter.setDescription("Text files");
				    jFileChooser.setFileFilter(filter);
					
					int value = jFileChooser.showOpenDialog(jFrame);
			
					if(value == JFileChooser.APPROVE_OPTION){
						mappingsPath = jFileChooser.getSelectedFile().getAbsolutePath();
						mappingsTextField.setText(mappingsPath);
					}

				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes mappingsTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMappingsTextField() {
		if (mappingsTextField == null) {
			mappingsTextField = new JTextField();
			mappingsTextField.setText("/Users/hekanibru/Documents/DPhil/Prototype/Tokyo/JapaneseWordNet/mappings_japanese.txt");
		}
		return mappingsTextField;
	}

	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(new BorderLayout());
			jPanel6.add(getJPanel10(), BorderLayout.CENTER);
			jPanel6.add(getJPanel7(), BorderLayout.SOUTH);
			jPanel6.add(getDBPanel(), BorderLayout.EAST);
		}
		return jPanel6;
	}

	/**
	 * This method initializes jPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jPanel7 = new JPanel();
			jPanel7.setLayout(new BorderLayout());
			jPanel7.add(getJPanel1(), BorderLayout.CENTER);
		}
		return jPanel7;
	}
}
