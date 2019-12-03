import java.util.Date;

/**
 * @author Lorenzo Cauli
 * @version 0.1
 */

/*
 - gay: long 
 - name: String 
 - birthDay: Date 
 - stand: Stand
 
 + JoJo() 
 + JoJo(in name: String, birthDay: Date, stand: Stand) 
 + JoJo(in in: JoJo)
 
 + getName(): String
 + getBirthDay(): Date
 + getStand(): Stand

 + toString(): String
 + equals(in oL Object): boolean
 */

public class JoJo {
	public static final long gay = Long.MAX_VALUE;
	private String name;
	private Date birthDay;
	private Stand stand;

	/**
	 * Costruttore di default
	 */
	public JoJo() {
		name = "Giovanni GioStar";
		birthDay = new Date();
		stand = new Stand();
	}

	/**
	 * Costruttore dati nome, compleanno e Stand.
	 * @param name Nome JoJo.
	 * @param birthDay Riferimento a oggetto Date.
	 * @param stand Riferimento a oggetto Stand.
	 */
	public JoJo(String name, Date birthDay, Stand stand) {
		if (name != null && birthDay != null && stand != null) {
			this.name = name;
			this.birthDay = new Date(birthDay.getTime());
			this.stand = new Stand(stand);
		}
	}

	/**
	 * Costruttore di copia.
	 * @param in Riferimento a oggetto JoJo.
	 */
	public JoJo(JoJo in) {
		if (in != null) {
			name = in.getName();
			birthDay = in.getBirthDay();
			stand = in.getStand();
		} else {
			name = "Giovanni GioStar";
			birthDay = new Date();
			stand = new Stand();
		}
	}

	/**Metodo che restituisce il nome. */
	public String getName() {
		return name;
	}

	/**Metodo che restituisce il compleanno. */
	public Date getBirthDay() {
		return new Date(birthDay.getTime());
	}

	/**Metodo che restituisce lo Stand. */
	public Stand getStand() {
		return new Stand(stand);
	}

	/**
	 * Metodo che restituisce lo stato dell'oggetto in una stringa.
	 * @return Una stringa.
	 */
	public String toString() {
		return "Name: " + name + "\nStand description:\n" + stand.toString() + "Birthday: " + birthDay.toString();
	}

	/**
	 * Metodo che confronta lo stato di due oggetti.
	 * @param o Riferimento a oggetto Object
	 * @return true se sono uguali, false se sono diversi.
	 */
	public boolean equals(Object o) {
		boolean out = true;
		if (o != null && o instanceof JoJo) {
			if (	((JoJo)o).getName() != name               ||
					!((JoJo)o).getBirthDay().equals(birthDay) ||
					!((JoJo)o).getStand().equals(stand)          ) out = false;
		}
		else out = false;		
		return out;
	}
}
