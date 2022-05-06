package thread;

public class UpperCaseAlphabetRunnableImpl extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print(); //부모의 print()호출..
	}

}
