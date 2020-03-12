import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MostrarTela extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String mensagemDigitada;
	private static Cliente cliente;
	private JTextArea tela;
	
	//main da classe responsável por executar e criar cliente
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarTela frame = new MostrarTela();
					
					cliente = new Cliente(frame);
					cliente.start();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//método para criação do frame
	public MostrarTela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 80, 520, 600);
		setResizable(false);
	
		setTitle("Chat Multithread!!!");
		contentPane = new JPanel();
		contentPane.setBackground(Color.green);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(10, 470, 500, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mensagemDigitada = textField.getText();
				if(!(mensagemDigitada.equals(""))){
					cliente.enviarMensagem(mensagemDigitada);
					textField.setText("");
				}
			}
		});
		btnNewButton.setToolTipText("Clique aqui para enviar a mensagem");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(380, 520, 100, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 10, 500, 470);
		contentPane.add(scrollPane);
		
		JTextArea textArea_ClienteRecebeu = new JTextArea();
		scrollPane.setViewportView(textArea_ClienteRecebeu);
		textArea_ClienteRecebeu.setEditable(false);
		textArea_ClienteRecebeu.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		this.tela = textArea_ClienteRecebeu;
		
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick();
			}
		});
		
		
		
	}
	public JTextArea getTela() {
		return tela;
	}

	public void setTela(String mensagem) {
		this.tela.append(mensagem);
	}
}