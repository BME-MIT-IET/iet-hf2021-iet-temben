UI Tests
-
Nagy Roland - SYQW1F

---
A ui tesztekhez Selenium-ot használtam.
IntelliJ IDEA-ben telepítettem a
`Selenium UI Testing` plugin.
[Ennek](https://www.jetbrains.com/help/idea/selenium.html#run-selenium-tests)
az útmutatónak a segítségével létrehoztam egy projektet a ui-tests
mappában.

Csináltam több teszt file-t, a különböző oldalakhoz.
A tesztek elején az felkonfigurálom a teszt környezetet: mekkora
legyen a böngésző ablak, és nyissa meg a megadott url-t.
A tesztekhez nem a lokális szerver url-t adtam meg, hanem az éleset:
https://schpincer.sch.bme.hu/.

Az egyes tesztesetekben azokat vizsgálom, hogy látható-e egy fontos
elem, létezik egy megadott szöveg, egy lista nem üres.
A termékek oldalon tesztelem a keresést úgy, hogy beírom a
keresőbe a `burger\n` szöveget. (Ez az egy teszt fut most hibára,
mert nem működik a keresés).
Tesztelem ezen az oldalon azt is, hogy egy termékre kattintva,
elő jön a felugró ablak, majd abban is tesztelem az inputokat.

Összesítetten tetszett a feladat.
Egyszerűen és gyorsan lehet a felhasználói felülethez automatizált
teszteket írni, amik a böngészőben futnak.
A bejelentkezéshez ködődő funkciókhoz nem írtam tesztet.
