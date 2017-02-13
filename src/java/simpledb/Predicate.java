package simpledb;

import java.io.Serializable;

/**
 * Predicate compares tuples to a specified Field value.
 */
public class Predicate implements Serializable {

    private static final long serialVersionUID = 1L;

    public int field_;

    public Op op_;

    public Field operand_;



    /** Constants used for return codes in Field.compare */
    public enum Op implements Serializable {
        EQUALS, GREATER_THAN, LESS_THAN, LESS_THAN_OR_EQ, GREATER_THAN_OR_EQ, LIKE, NOT_EQUALS;

        /**
         * Interface to access operations by integer value for command-line
         * convenience.
         * 
         * @param i
         *            a valid integer Op index
         */
        public static Op getOp(int i) {
            return values()[i];
        }

        public String toString() {
            if (this == EQUALS)
                return "=";
            if (this == GREATER_THAN)
                return ">";
            if (this == LESS_THAN)
                return "<";
            if (this == LESS_THAN_OR_EQ)
                return "<=";
            if (this == GREATER_THAN_OR_EQ)
                return ">=";
            if (this == LIKE)
                return "LIKE";
            if (this == NOT_EQUALS)
                return "<>";
            throw new IllegalStateException("impossible to reach here");
        }

    }
    
    /**
     * Constructor.
     * 
     * @param field
     *            field number of passed in tuples to compare against.
     * @param op
     *            operation to use for comparison
     * @param operand
     *            field value to compare passed in tuples to
     */
    public Predicate(int field, Op op, Field operand) {
        field_ = field;

        op_ = op;

        operand_ = operand;
    }

    /**
     * @return the field number
     */
    public int getField()
    {
        return field_;
    }

    /**
     * @return the operator
     */
    public Op getOp()
    {
       return op_;
    }
    
    /**
     * @return the operand
     */
    public Field getOperand()
    {
        return operand_;
    }
    
    /**
     * Compares the field number of t specified in the constructor to the
     * operand field specified in the constructor using the operator specific in
     * the constructor. The comparison can be made through Field's compare
     * method.
     * 
     * @param t
     *            The tuple to compare against
     * @return true if the comparison is true, false otherwise.
     */
    public boolean filter(Tuple t) {

        Op operator = getOp();

        //field number specified in constructor
        int fieldNum = getField();
        Field field = t.getField(fieldNum);

        //field operand specified in constructor
        Field operand = getOperand();



        System.out.print(operand.compare(operator, field)); 
        System.out.print(field);
        System.out.print(operator);
        System.out.println(operand);
        

        return (operand.compare(operator, field));

        
       
    }

    /**
     * Returns something useful, like "f = field_id op = op_string operand =
     * operand_string
     */
    public String toString() {
    
        return "f = " + field_ + "op = " + op_ + "operand = " + operand_; 
    }
}
