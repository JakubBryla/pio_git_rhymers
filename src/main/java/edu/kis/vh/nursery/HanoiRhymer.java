package edu.kis.vh.nursery;

/**
 * Rozszerza klasę {@link DefaultCountingOutRhymer} i dodaje logikę śledzenia
 * odrzuconych elementów.
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    /**
     * Licznik całkowitej liczby elementów odrzuconych przez metodę {@link #countIn(int)}.
     * Element jest odrzucany, jeśli próba jego dodania następuje, gdy wyliczanka nie jest pełna,
     * a jednocześnie dodawany element jest większy od elementu znajdującego się aktualnie na szczycie.
     */
    private int totalRejected = 0;

    /**
     * Zwraca całkowitą liczbę elementów, które zostały odrzucone.
     * Odrzucenie następuje w metodzie {@link #countIn(int)} pod określonymi warunkami.
     *
     * @return Całkowita liczba odrzuconych elementów od momentu utworzenia obiektu
     *         lub ostatniego resetu (jeśli dotyczy).
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     * Dodaje element ({@code in}) do wyliczanki.
     * Jeśli wyliczanka nie jest pełna ({@code !callCheck()}) i dodawany element {@code in}
     * jest większy od elementu znajdującego się aktualnie na szczycie ({@code peekaboo()}),
     * element jest odrzucany, a wewnętrzny licznik odrzuceń ({@code totalRejected})
     * jest inkrementowany.
     * W przeciwnym razie (jeśli wyliczanka jest pełna lub jeśli {@code in} jest mniejszy
     * lub równy elementowi na szczycie), element jest przetwarzany przez metodę
     * {@link DefaultCountingOutRhymer#countIn(int)} klasy nadrzędnej.
     *
     * @param in Wartość całkowita do potencjalnego dodania do wyliczanki.
     */
    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}