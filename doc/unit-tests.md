Unit tests
-
Szabó Gergely - RZPZTT

---

### A feladat elvégzése

Az első lépés volt a JUnit5 platform és a Mockito kotlin kompatibilis függőségek hozzáadása a pom.xml-hez, 
hogy ezáltal használhatóak legyenek teszteléshez. A teszteléshez először kerestem olyan funkcionalistást ami nem Getter
és Setter szintű tesztek írását teszi lehetővé. A két funkció (rendelés készítése és rendelés törlése) mind 60+ soros
függvény voltak, így az első lépésem egy új osztályba való kiszervezés volt. A teszetek aztán ennek a két osztálynak 
az újonnan létrejött függvényeihez készítettem. Ezen kívül az OrderService módosult részei is tesztelve lettek. 
A tezstelés közben sikerült találni két hibát is, amit rögtön javítottam is.

### Tesztek futtatása

A tesztek futtatása lehetséges vagy a `./mvnw clean test` parancs vagy a fejlesztő környezetbe beépített tesztelő modulon
hívott `run tests` gombbal. 

### Tesztek tervezése, és elkészítése

A kód részek átfogó tesztelése, lehetőleg minél több fajta várható (más viselkedést eredményező) bemenettel. 
A helyes működés ellenőrzése. A teszteket úgy kell elkészíteni, hogy ha valaki módosítja a működést, és az a működés 
eltér a mostanitól akkor jelezze, de ha a módosítás működés változást nem eredményez, akkor a teszt ugyan úgy engedje át.
Tesztelés előtt érdemes a tesztelendő funkcionalitást kis, könnyen értelmezhető részekre osztani, ha esetleg alapból nem 
így lett volna lefejlesztve.
