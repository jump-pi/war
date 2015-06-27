package appl.model;

import com.jumppi.frwk.util.*;

public class ModelSample {
	public static ModelSample getInstance() {
		return new ModelSample();
	}

	public String op() {
		return "processed at " + Util.formatDateTime2ANSI(new java.util.Date());
	}
}
