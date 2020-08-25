package io.github.egnaf.parser.json;

import io.github.egnaf.parser.Parser;

public class JsonParser implements Parser {

    @Override
    public <T> T decode(Object from, String to) {
        return null;
    }

    @Override
    public <T> T encode(String from, Class<T> to) {
        
        return null;
    }

    // FIXME: 25.08.2020 check and fix this method
    private static char[] trim(char[] json) {
        int size = json.length, leftOffset = 0, rightOffset = 0;
        char[] result = new char[size];
        char symbolLeft, symbolRight;
        boolean isLeftEnd = false, isRightEnd = false;

        for (int i = 0; i < size; i++) {
            symbolLeft = json[i];
            symbolRight = json[size - i - 1];

            if (!isLeftEnd && symbolLeft == ' ' || symbolLeft == '\t') leftOffset++;
            else isLeftEnd = true;

            if (!isRightEnd && symbolRight == ' ' || symbolRight == '\t') rightOffset++;
            else isRightEnd = true;
        }

        for (int i = 0, j = leftOffset; i < size - rightOffset - 1; i++, j++) {
            result[i] = json[j];
        }
        return result;
    }

    public static void main(String[] args) {
        char[] temp = new char[] {' ', ' ', 'a', 'b', ' '};
        System.out.println("out:");
        System.out.println(trim(temp));
    }

    // [ ]
    private int squareBracket;

    // { }
    private int braceBracket;

}
