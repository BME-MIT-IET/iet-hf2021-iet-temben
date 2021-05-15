# Manuális tesztek megtervezése, végrehajtása és dokumentálása

## Feladat leírás:

A manuális tesztelés során a tesztelő célja hogy olyan hibákat találjon az alkalmazásban, amelyek nem jöttek elő az automatizált tesztek során. Manuális tesztelés során leginkább az alkalmazás funkcionalitását teszteljük a felhasználó szemszögéből.

## Tesztelési technika:

A tesztelés során a Black Box tesztelési technikát alkalmaztuk mely során az alkalmazást egy felhasználó szemszögéből vizsgáltuk kipróbálva a rendszer összes funkcionalitását. A tesztelési technika a program kóddal annak belső felépítésével nem foglalkozik a tesztelő szimplán csak funkcionális tényezőket vizsgálta az alkalmazás futása közben, hogy az az éles rendszerben a felhasználók számára is helyesen működjön.

## Tanulság:

A tesztek során az alkalmazás legtöbb funkcióját sikerült tesztek alá vetni. A tesztek többségén az alkalmazás az elvárt működést produkálta azonban sikerült találni pár olyan hibát a tesztelés során mely vagy javítandók sürgősen vagy olyan hiba mellyen ellehet gondolkodni, hogy érdemese-e kijavítani. Az egyik hiba, amit sikerült találni az alkalmazás legfontosabb funkcióját érinti, ami nem más, mint a rendelés. Új nyitás létrehozásánál anomália lépett fel néhány esetben és a rendszer rendelési időszakban is úgy érzékelte, hogy nincs rendelési időszak ezzel blokkolva a rendelést. Egy másik hiba, amit sikerült találni, hogy a termék törlését megerősítő oldalon nem azt írja ki az alkalmazás, hogy termék törlése, hanem hogy tag törlése. A harmadik hiba, amit találtunk, hogy a különböző objektumok létrehozására szolgáló formokon nincs input validáció így akar üres adatokkal is létre lehet hozni például terméket. Tehát a manuális tesztek megmutatták, hogy az alkalmazásunk nagy részben helyesen működik.
