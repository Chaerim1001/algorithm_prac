SELECT DISTINCT P1.CART_ID
    FROM CART_PRODUCTS P1
    CROSS JOIN CART_PRODUCTS P2
    ON P1.CART_ID = P2.CART_ID AND P1.NAME = 'MILK' AND P2.NAME = 'YOGURT'