package plugin;

public class ToUpperPlugin implements Plugin {
	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "toUpper";
	}

	@Override
	public String helpMessage() {
		return "Modifies the selection with uppercases";
	}
}