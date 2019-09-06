import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainApplication extends JFrame {
	private ProgressController firstProgressBar = null;
	private ProgressController secondProgressBar;
	private ProgressController thirdProgressBar;
	private ProgressController fourthProgressBar;
	public MainApplication() {
		getContentPane().setLayout(null);
		
		JLabel lblThreadTestApplication = new JLabel("Thread Test Application");
		lblThreadTestApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblThreadTestApplication.setBounds(0, 0, 434, 32);
		getContentPane().add(lblThreadTestApplication);
		
		JLabel label = new JLabel("  1:");
		label.setBounds(0, 43, 48, 25);
		getContentPane().add(label);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(23, 43, 376, 25);
		getContentPane().add(progressBar);
		
		JLabel label_1 = new JLabel("  2:");
		label_1.setBounds(0, 79, 48, 25);
		getContentPane().add(label_1);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(23, 79, 376, 25);
		getContentPane().add(progressBar_1);
		
		JLabel label_2 = new JLabel("  3:");
		label_2.setBounds(0, 114, 48, 25);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("  4:");
		label_3.setBounds(0, 150, 48, 25);
		getContentPane().add(label_3);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(23, 115, 376, 25);
		getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(23, 151, 376, 25);
		getContentPane().add(progressBar_3);
		
		JLabel lblNewLabel = new JLabel("Grand Total:   0     ");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(325, 211, 109, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel label_4 = new JLabel("0");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(398, 48, 36, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("0");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(398, 84, 36, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("0");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(398, 119, 36, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("0");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(398, 155, 36, 14);
		getContentPane().add(label_7);
		
		firstProgressBar = new ProgressController(progressBar, label_4, lblNewLabel, 800);
		secondProgressBar = new ProgressController(progressBar_1, label_5, 1000);
		thirdProgressBar = new ProgressController(progressBar_2, label_6, 500);
		fourthProgressBar = new ProgressController(progressBar_3, label_7, 100);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(progressBar.getValue() == 0) {
					firstProgressBar.start();
					secondProgressBar.start();
					thirdProgressBar.start();
					fourthProgressBar.start();
				}
			}
		});
		btnNewButton.setBounds(10, 207, 72, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstProgressBar.pause();
				secondProgressBar.pause();
				thirdProgressBar.pause();
				fourthProgressBar.pause();
			}
		});
		btnPause.setBounds(92, 207, 72, 23);
		getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("Resume");
		btnResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstProgressBar.continueToRun();
				secondProgressBar.continueToRun();
				thirdProgressBar.continueToRun();
				fourthProgressBar.continueToRun();
			}
		});
		btnResume.setBounds(172, 207, 89, 23);
		getContentPane().add(btnResume);
	}
}
