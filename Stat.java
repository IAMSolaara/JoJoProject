/**
 * @author Lorenzo Cauli
 * @version 1.0
 */

/*
    - parameter: String
    - level: String

    + Stat()
    + Stat(in parameter, level: String)
    + Stat(in in: Stat)

    + getParameter(): String
    + getLevel(): String

    + toString(): String
    + equals(in o: Object): boolean
*/
public class Stat {
    private String parameter;
    private String level;

    /**Costruttore di default. */
    public Stat() {
        parameter = "Dick-sucking power";
        level = "A";
    }

    /**Costruttore dati parametro e livello.
     * @param parameter Nuovo parametro.
     * @param level Livello nuovo parametro.
     */
    public Stat(String parameter, String level) {
        if (parameter != null && level != null) {
            this.parameter = parameter;
            this.level = level;
        } else {
            this.parameter = "Dick-sucking power";
            this.level = "A";
        }
    }

    /**Costruttore di copia
     * @param in Riferimento a oggetto Stat
     */
    public Stat(Stat in) {
        if (in != null) {
            parameter = in.getParameter();
            level = in.getLevel();
        } else {
            parameter = "Dick-sucking power";
            level = "A";
        }
    }

    /**Metodo che restituisce il parametro.
     * @return Parametro.
     */
    public String getParameter() {
        return parameter;
    }

    /**Metodo che restituisce il livello del parametro.
     * @return Livello del parametro.
     */
    public String getLevel() {
        return level;
    }

    /**Metodo che restituisce lo stato dell'oggetto in una stringa.
     * @return Lo stato dell'oggetto.
     */
    public String toString() {
        return parameter + ": " + level;
    }

    /**Metodo che confronta lo stato di quest'oggetto con quello di un altro.
     * @param o Riferimento a oggetto Object
     * @return true se sono uguali, false se sono diversi
     */
    public boolean equals(Object o) {
        boolean out = true;
        if (o != null && o instanceof Stat) {
            if (((Stat) o).getLevel() != level || ((Stat) o).getParameter() != parameter)
                out = false;
        } else
            out = false;
        return out;
    }
}