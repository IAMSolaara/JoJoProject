package com.mentalabs.JoJoProject;

/**
 * @author Lorenzo Cauli
 * @version 0.1
 */
/*
	- name: String
	- ability: String
	- battleCry: String
	- stats: String[]

	+ Stand()
	+ Stand(in name, ability, battleCry: String , stats: String[])
	+ Stand(in in: Stand)

	+ getName(): String
	+ getAbility(): String
	+ getBattleCry(): String
	+ getStats(): String[]

	+ cry(): void

	+ toString(): String
	+ equals(in o: Object): boolean
*/

public class Stand{
	private String name;
	private String ability;
	private String battleCry;
	private String[] stats;

	/**Costruttore di default */
	public Stand() {
		name = "Power Cord Extension";
		ability = "Extend its length.";
		battleCry = "NHGNHNGH";
		stats = new String[6];
		for (int i = 0; i < stats.length; i++) {
			stats[i] = "E";
		}
	}

	/**Costruttore dati nome, abilita', battleCry e vettore di statistiche.
	 * @param name Nome del nuovo Stand.
	 * @param ability Abilita' del nuovo Stand.
	 * @param battleCry Battle cry del nuovo Stand.
	 * @param stats Riferimento a vettore di oggetti Stat.
	 */
	public Stand(String name, String ability, String battleCry, String[] stats) {
		this.stats = new String[6];
		if (name != null && ability != null && battleCry != null && stats != null) {
			this.name = name;
			this.ability = ability;
			this.battleCry = battleCry;
			if (this.stats.length == stats.length) {
				for (int i = 0; i < this.stats.length; i++) {
					this.stats[i] = stats[i];
				}
			} else
				for (int i = 0; i < stats.length; i++) {
					this.stats[i] = "E";
				}
		} else {
			this.name = "Power Cord Extension";
			this.ability = "Extend its length.";
			this.battleCry = "NHGNHNGH";
			for (int i = 0; i < stats.length; i++) {
				stats[i] = "E";
			}
		}
	}

	/**
	 * Costruttore di Copia.
	 * @param in Riferimento a oggetto Stand.
	 */
	public Stand(Stand in) {
		stats = new String[6];
		if (in != null) {
			name = in.getName();
			ability = in.getAbility();
			battleCry = in.getBattleCry();
			for (int i = 0; i < stats.length; i++) {
				stats[i] = in.getStats()[i];
			}
		} else {
			name = "Power Cord Extension";
			ability = "Extend its length.";
			battleCry = "NHGNHNGH";
			for (int i = 0; i < stats.length; i++) {
				stats[i] = "E";
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
	public String[] getStats() {
		String[] out = new String[this.stats.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = stats[i];
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
	 * Metodo che restituisce lo stato dell'oggetto in una stringa.
	 * @return Una stringa.
	 */
	public String toString() {
		String nameString = "「Ｓｔａｎｄ　ｎａｍｅ：　" + name + "」\n";
		String abilityString = "「Ｓｔａｎｄ　ａｂｉｌｉｔｙ：　" + ability + "」\n";
		String battleCryString = "「Ｓｔａｎｄ　ｃｒｙ：　" + battleCry + "」\n";
		String statsString = "Stand stats: \n";
		statsString += "Power " + stats[0] + "\n";
		statsString += "Speed " + stats[1] + "\n";
		statsString += "Range " + stats[2] + "\n";
		statsString += "Durability " + stats[3] + "\n";
		statsString += "Precision " + stats[4] + "\n";
		statsString += "Potential " + stats[5] + "\n";
		
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
