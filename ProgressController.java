import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressController extends Thread{
	private int waitTime;
	private JProgressBar associateProgressBar;
	private int associateProgressBarValue;
	private JLabel associateThreadLabel;
//	private int noSleepNeededValue = 0;
	//make GrandTotal static so it's shared by all threads
	private static JLabel sharedGrandTotalLabel;
	private static int sharedGrandTotalLabelValue;
	//indicate if the pause button is clicked
	private boolean paused = false;
	
	//constructor 1
	public ProgressController (JProgressBar givenProgressBar, JLabel givenThreadLabel, JLabel GrandTotalLabel, int givenWaitTime) {
		waitTime = givenWaitTime;
		associateProgressBar = givenProgressBar;
		associateProgressBarValue = givenProgressBar.getValue();
		sharedGrandTotalLabel = GrandTotalLabel;
		sharedGrandTotalLabelValue = Integer.valueOf(GrandTotalLabel.getText().split("   ")[1]);
		associateThreadLabel = givenThreadLabel;
	}
	//constructor 2
	public ProgressController (JProgressBar givenProgressBar, JLabel givenThreadLabel, int givenWaitTime) {
		waitTime = givenWaitTime;
		associateProgressBar = givenProgressBar;
		associateThreadLabel = givenThreadLabel;
	}
    public void run() {
    	while(associateProgressBarValue < 100) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {}
    		//pause button is clicked
			if(paused) {
    			try {
					Thread.sleep(3600000);
				} catch (InterruptedException e) {
					//when resume button is clicked, it will raise an interruptedException and come here
					continue;
				}
    		}
			//update progress bar and label
			++associateProgressBarValue;
			associateProgressBar.setValue(associateProgressBarValue);
			associateThreadLabel.setText(String.valueOf(associateProgressBarValue));
			//update grand total
			increaseGrandTotalLabel();
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {}
    	}
    }
    public void pause() {
    	paused = true;
    }
    public void continueToRun() {
    	paused = false;
    	interrupt();
    }
    //make it synchronized so that only one thread can invoke this method at a time
    private synchronized void increaseGrandTotalLabel() {
    	sharedGrandTotalLabel.setText("Grand Total:   " + String.valueOf(++sharedGrandTotalLabelValue));
    }
}
