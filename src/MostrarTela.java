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
		setBounds(650, 150, 600, 700);
		setResizable(false);
		setTitle("Olá, seja bem vindo !!!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(12, 569, 570, 37);
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(449, 615, 133, 37);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 570, 550);
		contentPane.add(scrollPane);
		
		JTextArea textArea_ClienteRecebeu = new JTextArea();
		scrollPane.setViewportView(textArea_ClienteRecebeu);
		textArea_ClienteRecebeu.setEditable(false);
		textArea_ClienteRecebeu.setFont(new Font("Arial",Font.PLAIN,17));
		
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