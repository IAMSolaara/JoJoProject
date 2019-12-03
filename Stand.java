/**
 * @author Lorenzo Cauli
 * @version 0.1
 */
/*
	- name: String
	- ability: String
	- battleCry: String
	- stats: Stat[]

	+ Stand()
	+ Stand(in name, ability, battleCry: String , stats: Stat[])
	+ Stand(in in: Stand)

	+ getName(): String
	+ getAbility(): String
	+ getBattleCry(): String
	+ getStats(): Stat[]

	+ cry(): void
	+ loadStat(in i: int , parameter, level: String): boolean

	+ toString(): String
	+ equals(in o: Object): boolean
*/

public class Stand {
	private String name;
	private String ability;
	private String battleCry;
	private Stat[] stats;

	/**Costruttore di default */
	public Stand() {
		name = "Power Cord Extension";
		ability = "Extend its length.";
		battleCry = "NHGNHNGH";
		stats = new Stat[6];
		for (int i = 0; i < stats.length; i++) {
			stats[i] = new Stat();
		}
	}

	/**Costruttore dati nome, abilita', battleCry e vettore di statistiche.
	 * @param name Nome del nuovo Stand.
	 * @param ability Abilita' del nuovo Stand.
	 * @param battleCry Battle cry del nuovo Stand.
	 * @param stats Riferimento a vettore di oggetti Stat.
	 */
	public Stand(String name, String ability, String battleCry, Stat[] stats) {
		this.stats = new Stat[6];
		if (name != null && ability != null && battleCry != null && stats != null) {
			this.name = name;
			this.ability = ability;
			this.battleCry = battleCry;
			if (this.stats.length == stats.length) {
				for (int i = 0; i < this.stats.length; i++) {
					this.stats[i] = new Stat(stats[i]);
				}
			} else
				for (Stat entry : this.stats) {
					entry = new Stat();
				}
		} else {
			name = "Power Cord Extension";
			ability = "Extend its length.";
			battleCry = "NHGNHNGH";
			for (Stat entry : this.stats) {
				entry = new Stat();
			}
		}
	}

	/**
	 * Costruttore di Copia.
	 * @param in Riferimento a oggetto Stand.
	 */
	public Stand(Stand in) {
		stats = new Stat[6];
		if (in != null) {
			name = in.getName();
			ability = in.getAbility();
			battleCry = in.getBattleCry();
		} else {
			name = "Power Cord Extension";
			ability = "Extend its length.";
			battleCry = "NHGNHNGH";
			for (Stat entry : stats) {
				entry = new Stat();
			}
		}
	}

	/**
	 * Metodo che restituisce il nome dello Stand.
	 * @return Il nome dello Stand.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo che restituisce l'abilita' dello Stand.
	 * @return L'abilita' dello Stand.
	 */
	public String getAbility() {
		return ability;
	}

	/**
	 * Metodo che restituisce il battle cry dello Stand.
	 * @return Il battle cry dello Stand.
	 */
	public String getBattleCry() {
		return battleCry;
	}

	/**
	 * Metodo che restituisce le statistiche dello Stand.
	 * @return Riferimento a un vettore di oggetti Stat.
	 */
	public Stat[] getStats() {
		Stat[] out = new Stat[this.stats.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = new Stat(stats[i].getParameter(), stats[i].getLevel());
		}
		return out;
	}

	/**
	 * Metodo che stampa in console il battle cry dello Stand.
	 */
	public void cry() {
		System.out.println(battleCry);
	}

	/**
	 * Metodo che carica una statistica dato indice, parametro e livello.
	 * @param i Indice statistica.
	 * @param param Parametro statistica.
	 * @param level Livello parametro statistica.
	 * @return true se i parametri sono validi, false se non lo sono.
	 */
	public boolean loadStat(int i, String param, String level) {
		boolean out = true;
		if (i < stats.length && param != null && level != null) {
			stats[i] = new Stat(param, level);
		} else
			out = false;
		return out;
	}

	/**
	 * Metodo che restituisce lo stato dell'oggetto in una stringa.
	 * @return Una stringa.
	 */
	public String toString() {
		String nameString = "「Ｓｔａｎｄ　ｎａｍｅ：　" + name + "」\n";
		String abilityString = "「Ｓｔａｎｄ　ａｂｉｌｉｔｙ：　" + ability + "」\n";
		String battleCryString = "「Ｓｔａｎｄ　ｃｒｙ：　" + battleCry + "」\n";
		String statsString = "Stand stats: \n";
		for (Stat entry : stats) {
			statsString += entry.toString() + "\n";
		}
		return nameString + abilityString + battleCryString + statsString;
	}

	/**
	 * Metodo che confronta lo stato di quest'oggetto con quello di un altro.
	 * @param o Riferimento a oggetto Object.
	 * @return true se sono uguali, false se sono diversi.
	 */
	public boolean equals(Object o) {
		boolean out = true;
		if (o != null && o instanceof Stand) {
			if ( 	((Stand)o).getName() != name ||
					((Stand)o).getAbility() != ability ||
					((Stand)o).getBattleCry() != battleCry ||
					!((Stand)o).getStats().equals(stats) ) out = false;
		} else
			out = false;
		return out;
	}
}
