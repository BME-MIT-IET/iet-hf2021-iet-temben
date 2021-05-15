# Manuális tesztek
## Navigáció tesztelése

Ezen tesztek célja, hogy az oldalon lévő menük illetve linkek helyes működéséről megbizonyosodjunk, hogy megfelelően működnek és az elvárt helyre navigálják a felhasználót.

## Side menü teszt:

Teszt terv: A teszt során az alkalmazás baloldalán található különböző körök ikonjaira való kattintás utáni helyes működést vizsgáljuk.

Teszt végrehajtás: Az oldalsó navigációs sávon a három ikon mindegyikére klikkelünk ezzel átnavigálva az adott körnek a részletes oldalára. 

| Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | --- | 
| A felhasználó átkerül a Pizzásch oldalára | A felhasználó átkerült a Pizzásch oldalára | :heavy_check_mark: |

## Navigációs menü teszt:

Teszt terv: A teszt során az alkalmazás tetején található navigációs sáv működését teszteljük, mely során az alkalmazásnak sikeresen át kell tudnia navigálnia a felhasználót a kiválasztott oldalakra.

Teszt végrehajtás: A felső navigációs sávon mindegyik link működésest teszteljük, majd az eredményt összehasonlítjuk az elvárttal. 

| Teszt | Elvárt eredmény |Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Sch-pincér logó | A felhasználó átkerül az alkalmazás fő oldalára | A felhasználó átkerült az alkalmazás fő oldalára. | :heavy_check_mark: |
| Szor menü elem | A felhasználó átkerül a szolgáltató reszort oldalára | A felhasználó átkerült a szolgáltató reszort oldalára | :heavy_check_mark: |
| Termékek menü elem | A felhasználó átkerül a termékek listáját tartalmazó oldalára. | A felhasználó átkerült a termékek listáját tartalmazó oldalára. | :heavy_check_mark: |
| Bejelentkezés menü elem | A felhasználó átkerül a bejelentkezésért felelős oldalra | A felhasználó átkerült a bejelentkezésért felelős oldalra. | :heavy_check_mark: |

## Termék Lista Menü elemek tesztjei:

Teszt terv: A teszt során a termékek oldalon található funkcionális elemeket kell tesztelni. A három menü pontot kell tesztelés alá vetni, hogy meggyőződhessünk a helyes működésükről.

Teszt végrehajtás: A teszt során a minden termék, rendelhető, illetve a holnap rendelhető menü pontokat kell kattintással tesztelni.

| Teszt | Teszt Adatok | Elvárt eredmény |Eredmény | Siker/Hiba
| ----- | ----------- | ------ | ---- | ---- |
| minden termék elem | Az adatbázisban található termékek. | Az összes elérhető termék megjelenik | A körökben elérhető összes termék megjelent. | :heavy_check_mark: |
| Rendelhető elem, ha nincs rendelhető termék | Az adatbázis rendelhető termékek része üres. | Nem jelenik meg egy termék sem a listában. | Nem jelent meg egy termék sem a listában. | :heavy_check_mark: |
| Rendelhető elem, ha van rendelhető termék | Az adatbázis rendelhető termékek részében egyetlen termék van a classic burger. | A listában megjelenik a classic burger. | A listában megjelent a classic burger. | :heavy_check_mark:|
| Holnap Rendelhető elem, ha nincs termék | Az adatbázis holnap rendelhető termékek része üres | Nem jelenik meg egy termék sem a listában. | Nem jelent meg egy termék sem a listában. | :heavy_check_mark: |
| Holnap Rendelhető elem, ha van termék | Az adatbázis holnap rendelhető termékek részében egyetlen termék van a sajtburger. | A listában megjelenik a sajtburger. | A listában megjelent a sajtburger. | :heavy_check_mark: |

## Termék Lista kereső mező tesztjei:

Teszt terv: A teszt során azt kell le tesztelni, hogy a termék lista oldal megfelelően működik. A tesztelés során a lehető legkülönbözőbb helyes illetve helytelen bemenetekkel kell próbálkozni, hogy, biztosítsuk azt, hogy egy keresés során csak helyes inputot fogadjon el az alkalmazás illetve a keresés során a megfelelő termékeke jelenjenek meg.

Teszt végrehajtás: Az input mezőbe különböző termékek nevével illetve más nem valid bemenetek próbálgatásával teszteljük az alkalmazást.

| Teszt | Teszt Adatok | Elvárt eredmény |Eredmény | Siker/Hiba
| ----- | ----------- | ------ | ---- | ---- |
| Valid bement az input mezőbe | Bemenet: burger | A listában csak olyan termékek jelennek meg melyeknek a nevében szerepel a bemenet. | A listában valóban csak a bemenetre illeszkedő termékek jelentek meg. | :heavy_check_mark: | 
| Helytelen bement az input mezőbe | Bemenet: asd | A listában nem jelenik meg egy termék sem | A listában nem jelent meg egy termék sem | :heavy_check_mark: |
| Helyes szó töredék az input mezőbe | Bemenet: ran | A listában a randomburger illetve a randi pizza jelenik meg ezeknek a neve illeszkedik a megadott bementre. | A listában randomburger illetve a randi pizza jelent meg | :heavy_check_mark: | 

## Autentikáció tesztjei:

Teszt terv: A bejelentkezés illetve kijelentkezés funkciót teszteljük. Az alkalmazásba az authentikáció az autsch-n keresztülműködik. A bejelentkezés gombra kattintva az autsh bejelentkező oldalra kell kerülnünk majd ott sikeres bejelentkezés után vissza az sch pincér oldalra már bejelentkezve.

Teszt végrehajtás: 

- Bejelentkezés: A bejelentkezés menüre kattintva átirányításra kerülünk az autsch oldalra itt belépünk edu azonosítóval vagy autsch accounttal majd vissza irányitásra kerülünk az schpincérre.

- Kijelentkezés: A felhasználói profilra navigálva a megnyomjuk a kijelentkezés gombot.

| Teszt | Teszt Adatok | Elvárt eredmény |Eredmény | Siker/Hiba
| ----- | ----------- | ------ | ---- | ---- |
| Bejelentkezés | A felhasználó bejelentkezése sikeres a menüben a bejelentkezés felirat helyett a neve látszik, amire kattintva a profiljára tud navigálni. | A felhasználó bejelentkezése sikeres megtörtént a menüben a bejelentkezés felirat helyett a neve látszott, amire kattintva a profiljára tudtunk navigálni.  | :heavy_check_mark: |
| Kijelentkezés | A kijelentkezés gombot megnyomva a rendszer kiléptette a felhasználót a menüben újra a bejelentkezés felirat látható. | A kijelentkezés gombot megnyomva a rendszer kiléptette a felhasználót a menüben újra a bejelentkezés felirat volt látható. | :heavy_check_mark: |


## Admin Dashboard tesztjei:

Teszt terv: A teszt során azt szeretnénk tesztelni, hogy az admin felhasználok számára elérhető funkciók megfelelően működnek és az admin felhasználok, el tudják látni feladataikat melyek során tudniuk, kell felvenni új köröket, szerkeszteni a köröket illetve tudnia kell törölni köröket, emellett a felhasználok listájában is tudnunk kell szerkeszteni a felhasználót illetve annak jogosultságait. A teszt során a különböző funkciókat a futó alkalmazáson élesben próbáljuk ki.

Teszt végrehajtás:
- Új kör felvétele: Az admin dashboardon az új kör feliratra kattintva át kell, hogy kerüljünk az új kör adataival kitölthető formra melyen az adatokat kitöltve az új kör gombot megnyomva sikeresen fel kell kerülni a körök listájában az általunk felvett körnek.

- Kör szerkesztése: Az admin dashbordon a szerkesztés ikont kell, meg nyomni ekkor át kell, hogy kerüljünk, a kör szerkesztése oldalra ahol az adatok ki vannak töltve a kör eddigi adataival valamelyik vagy akár az összes adatot szerkesztve a kör módosítása gombot meg nyomva változtatásainknak érvényre kell jutnia és újra megnyitva a szerkesztést vagy a kör adatlapjára navigálva a szerkesztett adatoknak kell szerepelnie.

- Kör törlése: A törlés ikonra való kattintás után a körnek törlődni kell a körök listájából.

- Navigálás a körvez dashboard-ra: A háromszög ikonra kattintva a körvez dashboardra kell, hogy kerüljünk.

- Felhasználó szerkesztése: A szerkesztés gombot megnyomva az adott felhasználót szerkesztő oldalra kell kerülni ahol jogosultságokat adunk az adott felhasználónak majd a szerkesztés gombot megnyomva ezeket a változtatásokat elmentjük.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Új kör felvétele | Létrejön az új kör a megadott adatokkal az admin dashborodon megjelenik a listában illetve a kör adatlapja is létrejön melyen a helyes adatok jelennek meg. | Létrejött az új kör a megadott adatokkal az admin dashborodon megjelent a listában illetve a kör adatlapja is létrejött a helyes adatokkal.  | :heavy_check_mark: |
| Új kör felvétele üres adatokkal | Az alkalmazás nem enged létrehozni új kör teljesen üres adatokkal az alap adatokat kötelező megadni. | Létrejött az új kör teljesen üres adatokkal. | :x: |
| Kör szerkesztése | Miután a kör valamely adatát módosítjuk, benn marad a körök listájában és a kör adatlapján a módosított adatok jelennek meg. | A kör egyik adatát módosítottuk benn maradt a körök listájában és a kör adatlapján a módosított adatok jelentek meg.  | :heavy_check_mark: |
| Kör törlése | A kör törlődik a körök listájából | A kör nem törlődött a körök listájából  | :x: |
| Navigálás a körvez dashboard-ra | A felhasználó átkerül a körvez dashboard oldalra. | A felhasználó átkerült a körvez dashboard oldalra.  | :x: |
| Admin jog felhasználónak | A felhasználónak a szerkesztés után admin jogokkal kell rendelkeznie | A felhasználó a szerkesztés után admin jogokkal kell rendelkezik.  | :heavy_check_mark: |
| Körvez jog felhasználónak | A felhasználónak a szerkesztés után körvez jogokkal kell rendelkeznie | A felhasználó a szerkesztés után körvez jogokkal kell, rendelkezik.  | :heavy_check_mark: |

## Körvez Dashboard tesztjei:

Teszt terv: A teszt célja hogy a körvez dashboard funkcionalitását leteszteljük. A dashboardon tudnunk kell szerkeszteni a körünk adatait, meg tekinteni a kör értékeléseit, létrehozni nyitásokat, új terméket felvenni illetve új tagokat felvenni. A funkciókat a futó alkalmazáson azok használatával teszteljük.

Teszt végrehajtás:
- Kör szerkesztése: A körszerkesztése gombot megnyomva a szerkesztés oldalra kell, hogy kerüljünk ekkor az előbbiekben az admin dashboard során is elvégzett lépéseket kell elvégezni.

- Értékelések megtekintése: Az értékeléseink gombot megnyomva az értékelések listáját tartalmazó oldalra kell kerülnünk ahol ha, van az értékeléskét kell látnunk.

- Új nyitás létrehozása: Új nyitás gombot megnyomva az újnyitás formra kell kerülnünk ahol, beírjuk az adatokat majd az újnyitás gombra kattintva létre kell, hogy jöjjön az újnyitás.

- Nyitás törlése: A beütemezett nyitások alatt, ha van nyitás a törlés gombra kattintunk ekkor a nyitásnak törlődnie kell.

- Új termék létrehozása: Új termék gombot megnyomva az újtermék formra kell kerülnünk ahol, beírjuk az adatokat majd az újtermék gombra kattintva létre kell, hogy jöjjön az újtermék.

- Termék törlése: A termékek alatt, ha van terméke a körnek a törlés gombra kattintunk, ekkor a terméknek törlődnie kell.

- Új tag létrehozása: Új tag gombot megnyomva az új tag formra kell kerülnünk ahol, beírjuk az új tag adatait majd az új tag gombra kattintva létre kell, hogy jöjjön az új tag.

- Tag törlése: Ha van a körben tag a törlés gombot megnyomva a tagnak törlődnie kell.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Kör szerkesztése | Miután a kör valamely adatát módosítjuk, benn marad a körök listájában és a kör adatlapján a módosított adatok jelennek meg. | A kör egyik adatát módosítottuk benn maradt a körök listájában és a kör adatlapján a módosított adatok jelentek meg.  | :heavy_check_mark: |
| Értékelések megtekintése | A felhasználónak az értékeléseket tartalmazó oldalra kell kerülnie. |  A felhasználó az értékeléseket tartalmazó oldalra kerül.t | :heavy_check_mark: |
| Nyitás létrehozása adatokkal | A nyitás létre kell jönnie a megadott adatokkal |  A nyitás létre jött a megadott adatokkal, a nyitások listájában is megjelent  | :heavy_check_mark: |
| Nyitás létrehozása adatok nélkül | A rendszernek nem szabadna létrehozni a nyitást az alap adatokat kötelező megadni. |  A nyitásnak létre jött üres illetve deafult adatokkal, a nyitások listájában is megjelent.  | :x: |
| Nyitás törlése | A nyitásnak törlődni kell a nyitások közül. | A nyitás törlődött nyitások közül. | :heavy_check_mark: |
| Új termék létrehozása adatokkal| A terméknek létre kell jönnie a megadott adatokkal. |  A termék létrejött a megadott adatokkal. | :heavy_check_mark: |
| Új termék létrehozása adatok nélkül | A rendszernek nem szabadna létrehozni a terméket az alap adatokat kötelező megadni. | A termék létre jött üres adatokkal, a termékek listájában is megjelent. | :x: |
| Termék törlése | A terméknek törlődni kell a termékek közül. | A termék törlődőt a termékek közül viszont a törlés megerősítésé oldalon tag törlése szöveg volt látható (működés helyes). | :x: |
| Termék módosítása | Miután a termék valamely adatát módosítjuk benn marad a termékek listájában és a termék adatlapján a módosított adatok jelennek meg. | A termék egyik adatát módosítottuk benn maradt a körök listájában és a termék adatlapján a módosított adatok jelentek meg. | :heavy_check_mark: |
| Tag felvétele adatokkal | A tagnak létre kell jönnie a megadott adatokkal. | A tag létrejött a megadott adattokkal. | :heavy_check_mark: |
| Tag felvétele adatok nélkül | A tagnak nem szabadna létrejönni hiányos adatokkal. | A tag létrejött hiányos adatokkal. | :heavy_check_mark: |
| Tag törlés | A tagnak törlődni kell a tagok közül. | A tag törlődött a tagok közül. | :heavy_check_mark: |
| Tag szerkesztése |  Miután a tag valamely adatát módosítjuk benn marad a tagok listájában és módosított adatokkal jelenik meg. | A tag a listában marad és a módosított adatokkal jelent meg. | :heavy_check_mark: |

## Felhasználó adatlap szerkesztésének tesztje:

Teszt terv: Ebben a tesztben a felhasználói adatlapon elérhető egyetlen szerkeszthető adat szerkeszthetőségét és helyes működést teszteljük. A szerkeszthető adat a szobaszám melynek a teszt során helyes és helytelen adatoka is megadunk ezzel tesztelve, hogy az esetlegesen helytelen szóba számot is elfogadja a rendszer.

Teszt végrehajtása: A felhasználói adatlapon a szóba szám mezőnél található szerkesztés ikonra kattintunk majd meg adjuk a kívánt adatot majd entert nyomva változtatásainkat menti a rendszer.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Szóba szám szerkesztése helyes adattal | Szerkesztés után a megadott adatnak kell szerepelnie a szobaszám mezőben. | Szerkesztés után a megadott adat szerepel a szobaszám mezőben.  | :heavy_check_mark: |
| Szóba szám szerkesztése helytelen adattal | A rendszer nem fogad el olyan bementet mely nem a kollégiumban megtalálható szobának a száma. | A mező bármilyen adatott elfogadott. | :x: |

## Új nyitás létrehozása, törlése:

Teszt terv: A teszt során a körvez dashboardon már tesztelt új nyitás funkció azon részét teszteljük mely más felhasználók szemszögéből nézi az újnyitás létrejöttét, azaz a nyitás megjelink a felhasználók számára illetve a helyes adatokat látják a nyitásról.

Teszt végrehajtása: A körvez jogosultságokkal rendelkező felhasználóval létrehozunk, egy új nyitást majd egy másik felhasználóval megnézzük, hogy a nyitások listájában szerepel-e a létrehozott nyitás illetve adatlapján a megfelelő adatokat olvashatjuk. Majd töröljük az eseményt és megnézzük, hogy változott-e a másik felhasználónál is.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Új nyitás létrehozása | A nyitás létrehozása után a felhasználóknak létrejön a nyitás a megadott adatokkal. | A nyitás létrehozása után a felhasználóknak létrejött a nyitás a megadott adatokkal.  | :heavy_check_mark: |
| Nyitás törlés | A nyitás törlése esetén a felhasználóknak is törlődik az esemény a nyitások listájából. | A nyitás törlése után a felhasználóknak is törlődött a nyitás. | :heavy_check_mark: |

## Új termék létrehozása, törlése:

Teszt terv: A teszt során a körvez dashboardon már tesztelt új termék felvétele funkció azon részét teszteljük mely más felhasználók szemszögéből nézi az újtermék létrejöttét, azaz a termék megjelink a felhasználók számára a termékek listájában illetve a helyes adatokat szerepelnek a termékről.

Teszt végrehajtása: A körvez jogosultságokkal rendelkező felhasználóval létrehozunk, egy új terméket majd egy másik felhasználóval megnézzük, hogy a termékek listájában szerepel-e a létrehozott termék illetve adatlapján a megfelelő adatokat olvashatjuk. Majd töröljük a terméket és megnézzük, hogy változott-e a másik felhasználónál is.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Új termék létrehozása | A termék létrehozása után létrejön a termék a termékek listájában a megadott adatokkal. | A termék létrehozása után a felhasználóknak létrejött a termék a megadott adatokkal.  | :heavy_check_mark: |
| Termék törlés | A termék törlése esetén a felhasználóknak is törlődik a termék a termékeke listájából. | A termék törlése után a felhasználóknak is törlődött a termék. | :heavy_check_mark: |

## Új tag felvétele, törlése:

Teszt terv: A karvezetők egy fontos funkciója hogy tagokat tudjanak felvenni körükben ezt, fogjuk tesztelni mind körvezetői oldalról illetve felhasználói oldalról, hogy a tagok listájában megjelennek az újonnan felvett tagok illetve törlés során el is tűnnek.

Teszt végrehajtása: A körvez jogosultságokkal rendelkező felhasználóval létrehozunk, egy új tagot majd egy másik felhasználóval megnézzük, hogy a tagok listájában szerepel-e a létrehozott tag illetve adatlapján a megfelelő adatokat olvashatjuk. Majd töröljük a tagot és megnézzük, hogy változott-e a másik felhasználónál is.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Új tag felvétele | A tag felvétele után létrejön a tag a tagok listájában a megadott adatokkal. | A tag  felvétele után a felhasználóknak létrejött a tag a megadott adatokkal.  | :heavy_check_mark: |
| Tag törlés | A tag törlése esetén a felhasználóknak is törlődik a tag a tagok listájából. | A tag törlése után a felhasználóknak is törlődött a tag. | :heavy_check_mark: |


## Rendelés:

Teszt terv: Ezen tesztek során az alkalmazás fő funkcionalitását fogjuk tesztelni, ami nem más, mint a rendelés. Meg kell győződni róla, hogy egy rendelés leadása esetén a megadott opciókkal jön létre a rendelés. A felhasználó a rendelései közt látja a rendelését illetve a kör tagjai is látják a rendelésünket a nyitás rendeléseinek listájában. Ezek mellett meg kell győződnünk arról, hogy a kör által megadott limitek átlépését nem engedi a rendszer. Illetve hogy a felhasználó tudja-e törölni a rendelését.

Teszt végrehajtása: A teszt során létre kell, hozzunk egy nyitást mely során a felhasználok, rendelhetnek termékeket, ezt a funkciót már a körvez dashboard tesztelése során leteszteltük. Majd ezután egy fogyasztó szerepű felhasználói profillal rendeléseket kell leadnunk a különböző termékekere, eközben megpróbálva átlépni a limiteket.

| Teszt | Elvárt eredmény | Eredmény | Siker/Hiba |
| ----- | ----------- | ------ | --- |
| Rendelés rendelési időszakon kívül | A termékre kattintva nem elérhető a rendelés gomb| A termék nevére kattintva nem volt látható a rendelés gomb.  | :heavy_check_mark: |
| Rendelés rendelési időszakban | A terméket megtudjuk rendelni a felhasználó rendeléseinek listájába és a kör rendeléseinek listájába is bekerül a rendelés. | A terméket megtudjuk rendelni a felhasználó rendeléseinek listájába és a kör rendeléseinek listájába is bekerült a rendelés. | :heavy_check_mark: | 
| Rendelés, ha nyitási limit megtelt | A rendszer nem enged több rendelést leadni | A rendszer nem engedett több rendelést leadni | :heavy_check_mark: |
| Rendelés, ha kategória limit megtelt | A rendszer nem enged több rendelést leadni adott kategóriába található termékekre. | A rendszer nem engedett több rendelést leadni adott kategóriába található termékekre. | :heavy_check_mark: |
| Rendelés maximum időszakon belül | Rendszer nem enged több rendelést leadni, ha elérjük az adott időszak béli limitet.  | Rendszer nem engedett több rendelést leadni. | :heavy_check_mark: |

A rendelés a tesztelés során nem determinisztikus működést pordukált, ha létrehoztunk egy új nyitást nem lehetet mindig rendelni mivel a rendszer úgy érzékelte, hogy nincs rendelési időszak.
