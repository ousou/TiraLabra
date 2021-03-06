package polynomial;

/**
 * Interface for a single variable polynomial with coefficients from Z or Z_{n}.
 * 
 * Only non-negative degrees are accepted.
 * 
 * Example: x^3 + 2x^2 + 1
 * 
 * The polynomial can only be evaluated in integer points.
 * 
 * @author Sebastian Björkqvist
 */
public interface IPolynomial {

    /**
     * Returns the characteristic of the ring of coefficients.
     * 
     * Zero implies that the coefficient ring is the ring of integers.
     * 
     * This affects all calculations involving the polynomial.
     * 
     * @return The characteristic.
     */
    int getCharacteristic();
    
    /**
     * Returns the degree of the polynomial.
     *  
     * The degree means the highest exponent of the polynomial.
     * 
     * The degree of the empty/zero polynomial is -1.
     * 
     * @return Degree as integer.
     */
    int getDegree();
    
    /**
     * Returns the number of non-zero coefficients in the polynomial.
     * 
     * @return Number of non-zero coefficients.
     */
    int getNumberOfNonZeroCoefficients();
    
    /**
     * Adds a term to the polynomial.
     * 
     * @param coefficient Coefficient of term to be added
     * @param exponent Exponent of term to be added. Must be non-negative.
     * @throws IllegalArgumentException if exponent is negative.
     */
    void addTerm(int coefficient, int exponent);
    
    /**
     * Removes the term at the given exponent from the polynomial.
     * 
     * If the polynomial doesn't contain the given term, nothing is done.
     * 
     * @param exponent Exponent of term to be removed. Must be non-negative.
     * @throws IllegalArgumentException if exponent is negative.
     */
    void removeTerm(int exponent);    
    
    /**
     * Evaluates the polynomial at the given point.
     * 
     * The evaluation will be done in the ring of integers.
     * 
     * @param value The value in which to evaluate the polynomial
     * @return The result of the evaluation.
     */
    int evaluate(int value);
    
    /**
     * Returns the coefficient of the leading term.
     * 
     * @return coefficient of leading term
     */
    
    int getCoefficientOfLeadingTerm();
    
    /**
     * Returns the coefficient at the given degree.
     * 
     * @param degree The degree, must be non-negative.
     * @throws IllegalArgumentException if degree is negative.
     * @return The coefficient, may be zero if the polynomial doesn't have a
     * term of the given degree.
     */
    int getCoefficientAtDegree(int degree);
    
    /**
     * Adds the given polynomial to this polynomial.
     * 
     * The operation does not change this polynomial.
     * 
     * @param polynomial The polynomial to add
     * @throws IllegalArgumentException if the characteristic of the polynomial given
     * differs from the characteristic of this polynomial.
     * @throws IllegalArgumentException if the polynomial given is null
     * @throws UnsupportedOperationException if the implementation of the other
     * polynomial is not supported by this polynomial.
     * @return A new polynomial that is the result of the addition.
     */
    IPolynomial add(IPolynomial polynomial);
    
    /**
     * Adds the given polynomial from this polynomial.
     * 
     * The operation does not change this polynomial.
     * 
     * @param polynomial The polynomial to subtract
     * @throws IllegalArgumentException if the characteristic of the polynomial given
     * differs from the characteristic of this polynomial.
     * @throws IllegalArgumentException if the polynomial given is null     
     * @throws UnsupportedOperationException if the implementation of the other
     * polynomial is not supported by this polynomial.
     * @return A new polynomial that is the result of the subtraction.
     */
    IPolynomial subtract(IPolynomial polynomial);    
    
    /**
     * Multiplies the given polynomial with this polynomial.
     * 
     * The operation does not change this polynomial.
     * 
     * @param polynomial The polynomial to multiply with
     * @throws IllegalArgumentException if the characteristic of the polynomial given
     * differs from the characteristic of this polynomial.
     * @throws IllegalArgumentException if the polynomial given is null
     * @throws UnsupportedOperationException if the implementation of the other
     * polynomial is not supported by this polynomial. 
     * @return A new polynomial that is the result of the multiplication
     */
    IPolynomial multiply(IPolynomial polynomial);
    
    /**
     * Divides this polynomial with the given polynomial.
     * 
     * The division is not supported for characteristic 0 if the result would
     * contain non-integer coefficients. 
     * 
     * @param polynomial The divisor.
     * @throws IllegalArgumentException if the characteristic of the polynomial given
     * differs from the characteristic of this polynomial.
     * @throws IllegalArgumentException if the polynomial given is null or zero.
     * @throws UnsupportedOperationException if the implementation of the other
     * polynomial is not supported by this polynomial. 
     * @throws UnsupportedOperationException if the characteristic of the polynomials
     * are zero and the result would contain non-integer coefficients.
     * @throws UnsupportedOperationException if the characteristic of the polynomials
     * is non-prime and the result would contain coefficients which aren't in the ring.
     * @return The DivisionResult-tuple that contains the quotient and the remainder.
     */
    DivisionResult divide(IPolynomial polynomial);

    /**
     * Returns a copy of this polynomial.
     * 
     * The copy has no ties to this polynomial.
     * 
     * @return Copy of polynomial.
     */
    IPolynomial createCopyOfPolynomial();
    
    /**
     * Returns a string representation of the polynomial.
     * 
     * Example: x^3 + 2x^2 + 1
     * @return String representation of polynomial.
     */
    @Override
    String toString();
}
