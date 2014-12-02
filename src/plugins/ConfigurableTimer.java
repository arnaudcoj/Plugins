/**
 * 
 */
package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author Nabil Maiz
 * @author Cojez Arnaud
 */
public class ConfigurableTimer implements java.awt.event.ActionListener {

	// ATTRIBUTES
	protected final int maxIteration;
	protected int nbIterations;
	protected final ActionListener listener;
	
	// CONSTRUCTOR
	/**
	 * Constructor
	 * @param maxIteration
	 * @param listener
	 */
	public ConfigurableTimer( ActionListener listener,int maxIteration) {
		super();
		this.maxIteration = maxIteration;
		this.listener = listener;
	}
	/**
	 * Constructor
	 * @param listener
	 */
	public ConfigurableTimer(ActionListener listener){
		this(listener,0);
	}
	
	/**
	 * @param milliseconds
	 */
	public void start(int milliseconds){
		nbIterations = 0;
		Timer timer = new Timer(milliseconds,this);
		timer.start();
		
		while(maxIteration ==0 || nbIterations <maxIteration){
			System.out.println(" ");
		}
		
		timer.stop();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		nbIterations++;
		listener.actionPerformed(e);
	}
	
	
}
