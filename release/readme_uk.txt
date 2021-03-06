@@TRANSLATION_NOTICE@@

==============================================================================
  ОмегаТ 3.0, файл Read Me

  1. Про ОмегаТ
  2. Що таке ОмегаТ?
  3. Установка ОмегаТ
  4. Як допомогти ОмегаТ
  5. ОмегаТ працює неправильно? Потрібна допомога?
  6. Дані про випуск

==============================================================================
  1. Про ОмегаТ


Найсвіжішу інформацію про ОмегаТ можна знайти на веб-сайті
      http://www.omegat.org/

Підтримка користувачів здійснюється в багатомовній групі користувачів на Yahoo (архіви цієї групи доступні без підписки):
     http://groups.yahoo.com/group/OmegaT/

Запити на нові можливості (англійською мовою) можна розмістити на сайті SourceForge:
     http://sourceforge.net/tracker/?group_id=68187&atid=520350

На цьому ж сайті можна опублікувати повідомлення про помилки (англійською мовою):
     http://sourceforge.net/tracker/?group_id=68187&atid=520347

================================================== ============================
  2. Що собою являє ОмегаТ?

ОмегаТ - програма автоматизованого перекладу (CAT, Computer Assisted Translation). Це вільна програма. Це означає, що за її використання (у тому числі в професійних цілях) не потрібно нікому платити. Крім того, її можна вільно змінювати та/або поширювати за умови дотримання ліцензійної угоди.

Основні функції ОмегаТ:
  - Запускається в будь-якій операційній системі, що підтримує Java;
  - Підтримує роботу з пам'яттю перекладів у форматі TMX;
  - Гнучка сегментація на речення (за методикою схожою з SRX);
  - Пошук в проекті та в зовнішніх файлах пам'яті перекладів;
  - Пошук файлів в форматах, які підтримує ОмегаТ в будь-якому каталозі;
  - Знаходження нечітких збігів;
  - Інтелектуальна обробка проектів, у тому числі зі складними ієрархіями каталогів;
  - Підтримка глосаріїв (термінологічна довідка);
  - Підтримка вільних програм перевірки орфографії;
  - Підтримка словників формату StarDict;
  - Підтримка служби машинного перекладу Google Translate;
  - Доступна і вичерпна документація;
  - Документація і інтерфейс перекладені багатьма мовами.

У ОмегаТ підтримує наступні формати файлів:

- Текстові фали (plain text)

  - Тексти ASCII (.txt тощо)
  - Кодований текст (*.UTF8)
  - Пакети Java resource (*.properties);
  - Файли PO (*.po)
  - Файли INI (Ключ=Значення) (*.ini)
  - Файли DTD (*.DTD)
  - Файли DocuWiki (*.txt)
  - Файли субтитрів SubRip (*.srt)
  - Файли локалізації Magneto CE (*.csv)

- Текстові фали з тегами

  - Файли OpenOffice.org / OpenDocument (*.odt, *.ott, *.ods, *.ots, *.odp, *.otp)
  - Файли Microsoft Open XML (*.docx, *.xlsx, *.pptx)
  - Файли (X) HTML (*.html, *.xhtml,*.xht)
  - Файли HTML Help Compiler (*.hhc, *.hhk)
  - Файли DocBook (*.xml)
  - Одномовні XLIFF (*.xlf, *.xliff, *.sdlxliff)
  - Файли QuarkXPress CopyFlowGold (*.tag, *.xtg)
  - Файли ResX (*.resx)
  - Файли Android resource (*.xml)
  - Файли LaTex (*.tex, *.latex)
  - Файли Допомоги (*.xml) та Керівництва користувачів (*.hmxp)
  - Файли Typo3 LocManager (*.xml)
  - Файли WiX Localization (*.wxl)
  - Файли Iceni Infix (*.xml)
  - Файли Flash XML export (*.xml)
  - Файли Wordfast TXML (*.txml)
  - Camtasia для Windows (*.camproj)
  - Файли Visio (*.vxd)

ОмегаТ можна також розширювати для підтримку інших форматів файлів.

ОмегаТ автоматично обробить навіть найскладнішу ієрархію початкових каталогів, знайде всі файли, що підтримуються й створить каталог перекладу з ідентичною структурою, куди будуть також скопійовані і файли в форматах, які не підтримуються.

Щоб швидко ознайомитися з можливостями ОмегаТ, запустіть програму і прочитайте коротке керівництво в головному вікні.

Повне керівництво користувача поставляється разом з програмою, його можна знайти в меню «Довідка».

==============================================================================
 3. Установка ОмегаТ

3.1 Загальна частина
Для запуску ОмегаТ необхідно, щоб у вашій системі було встановлено Java Runtime Environment версії 1.5 чи більше. Щоб заощадити ваш час,  пропонуються також пакети, що встановлюють відразу і ОмегаТ, і Java Runtime Environment.

Якщо Java у вас вже встановлена, то найпростіше встановити поточну версію ОмегаТ за допомогою Java Web Start.
Для цього, завантажте вказаний нижче файл і запустіть його:

   http://omegat.sourceforge.net/webstart/OmegaT.jnlp

У результаті на ваш комп'ютер буде встановлена ОмегаТ і пакет програмного забезпечення, необхідний для її роботи. Подальша наявність з'єднання з Інтернет не обов'язкова.

Протягом установки, залежно від операційної системи, можуть з'явитися кілька попереджень системи безпеки. Сертифікат самостійно підписаний від імені Дідьє Бріеля (Didier Briel).
Права, які ви надаєте цій версії (вони можуть бути сформульовані, наприклад, як: «необмежений доступ до комп'ютера») ідентичні правам, які є у локально встановленої версії (процедуру її установки ми розглянемо пізніше), а саме: дозволяється доступ до жорсткого диску вашого комп'ютера. При наступних запусках OmegaT.jnlp, за наявності доступу до Інтернет, буде перевіряти наявність оновлень. Якщо ви захочете їх встановити, то ОмегаТ запуститься після встановлення оновлень.

ОмегаТ можна встановити й іншими способами:

Якщо у вас встановлені Windows чи Linux і є JRE необхідної версії, то можете завантажити версію ОмегаТ без JRE (інсталяційний пакет можна відрізнити за маркуванням «Without_JRE» після номера версії).
Якщо ви сумніваєтеся, то ми рекомендуємо вам скористатися версією з JRE. Це цілком безпечно, навіть якщо у вашій системі вже встановлена JRE, ця версія не буде з нею конфліктувати.

Користувачі Linux:
ОмегаТ працюватиме з вільними реалізаціями Java, які поставляються з багатьма дистрибутивами Linux (наприклад, Ubuntu), але, можливо, ви зіткнетеся з помилками або непрацюючими функціями. Ми рекомендуємо завантажити та встановити або Oracle Java Runtime Environment (JRE), або версію ОмегаТ з JRE (файл *.tar.bz2 позначений «Linux»). Якщо ви встановили Java в своїй системі, то переконайтеся, що папка в якій вона встановлена вказана у змінній PATH, або при запуску ОмегаТ вказуйте повний шлях до Java. Якщо ви не дуже обізнані з Linux, то радимо використовувати версію ОмегаТ з JRE. Це цілком безпечно, JRE не конфліктуватиме з іншими реалізаціями Java, які можуть бути вже встановлені в вашій системі.

Користувачі Mac:
У версіях Mac OS X до Mac OS X 10.7 (Lion) JRE вже встановлена. При першому запуску програми, для роботи якого необхідна Java, Mac OS X Lion запропонує користувачеві автоматично завантажити та встановити її.

Користувачам Linux на PowerPC:
вам доведеться завантажити JRE в реалізації IBM, оскільки Sun не надає JRE для PPC-систем. Це можна зробити за адресою:

    http://www.ibm.com/developerworks/java/jdk/linux/download.html


3.2 Установка
* Користувачі Windows:
Просто запустіть програму установки. Якщо хочете, програма установки може створити ярлики для запуску ОмегаТ.

* Користувачі Linux:
Помістіть архів у будь-яку відповідну папку і розпакуйте його. Після цього ОмегаТ готова до роботи. Також, ви може скористатися зручним скриптом установки (linux-install.sh). Для цього, відкрийте вікно емулятора термінала (командний рядок, або консоль), перейдіть в папку, яка містить OmegaT.jar та linux-install.sh, і виконайте скрипт за допомогою команди "./linux-install.sh".

* Користувачі Mac:
Скопіюйте архів OmegaT.zip в будь-яку відповідну папку і розпакуйте його щоб отримати папку в якій міститься HTML-файл змісту документації і файл програми OmegaT.app.

* Інші користувачі (Solaris, FreeBSD тощо):
Щоб встановити ОмегаТ, просто створіть для неї відповідну папку. Скопіюйте туди архів zip або tar.bz2 з ОмегаТ і розпакуйте.

3.3 Запуск ОмегаТ
Запустіть ОмегаТ як описано нижче.

* Користувачі Windows:
Якщо під час встановлення ви вибрали створення ярлика на робочому столі, то просто двічі клацніть по ньому мишею. Якщо ж ні, то просто двічі клацніть мишею по файлу OmegaT.exe. Якщо у файловому менеджері (Провіднику Windows) ви бачите тільки файл OmegaT, але не OmegaT.exe, увімкніть відображення розширень файлів в налаштуваннях Провідника Windows.

* Користувачі Linux:
Якщо ви скористалися наданим скриптом установки, ви можете запустити ОмегаТ натиснувши
Alt+F2
і ввівши у вікні:
omegat

* Користувачі Mac:
Двічі клацніть мишею по файлу OmegaT.app.

* З файлового менеджера (всі системи):
Двічі клацніть по файлу OmegaT.jar. Це спрацює, тільки якщо JAR-файли асоційовані в операційній системі з програмою Java.

* З командного рядка (всі системи):
Для запуску Omegat введіть команду:

cd <папка, в якій знаходиться OmegaT.jar>

<Шлях до файлу програми Java і його ім'я> -jar OmegaT.jar

(Файл програми Java - це файл java.exe в Windows і java в Linux.
Якщо Java встановлена на системному рівні, повний шлях до файлу Java вводити не обов'язково.)

Налаштування запуску ОмегаТ

* Користувачі Windows:
Програма установки може створити ярлики в головному меню, на робочому столі і на панелі швидкого запуску. Крім того, можна вручну перетягнути файл OmegaT.exe в меню «Пуск», на робочий стіл або на панель швидкого запуску і так створити там ярлик.

* Користувачі Linux:
Для зручного запуску ОмегаТ можна використовувати наявний Kaptain-скрипт (omegat.kaptn). Для використання цього скрипта, спочатку треба встановити Kaptain. Потім, Kaptain-скрипт можна запустити, натиснувши
Alt+F2
і ввівши:
omegat.kaptn

Для отримання детальнішої інформації про Kaptain і про додавання відповідних пунктів у меню, прочитайте HowTo «OmegeT в Linux».

Користувачі Mac:
Для зручності запуску, просто перетягніть OmegaT.app в док або на панель Finder. Також, ОмегаТ завжди можна запустити за допомогою Spotlight.

==============================================================================
 4. Участь у проекті ОмегаТ

Щоб взяти участь у розробці ОмегаТ, зв'яжіться з розробниками за адресою:
    http://lists.sourceforge.net/lists/listinfo/omegat-development

Якщо ви хочете перекласти інтерфейс ОмегаТ, керівництво користувача чи інші документи, прочитайте наступне:
      
      http://www.omegat.org/en/translation-info.html

І підпишіться на список розсилки перекладачів:
      http://lists.sourceforge.net/mailman/listinfo/omegat-l10n

Якщо у вас є інші пропозиції, підпишіться на список розсилки для користувачів:
      http://tech.groups.yahoo.com/group/omegat/

І поринете в світ ОмегаТ...

  Творець ОмегаТ - Keith Godfrey;
  Координатор проекту ОмегаТ - Marc Prior;

У розробці взяли участь (в алфавітному порядку):

Програмісти:
  Zoltan Bartko
  Volker Berlin
  Didier Briel (керівник розробки)
  Kim Bruning
  Alex Buloichik (провідний розробник)
  Sandra Jean Chua
  Thomas Cordonnier
  Martin Fleurke  
  Wildrich Fourie
  Phillip Hall
  Jean-Christophe Helary
  Thomas Huriaux
  Hans-Peter Jacobs
  Kyle Katarn
  Ibai Lakunza Velasco
  Guido Leenders
  Aaron Madlon-Kay
  Fabián Mandelbaum
  John Moran
  Maxym Mykhalchuk 
  Arno Peters
  Henry Pijffers 
  Briac Pilpré
  Tiago Saboga
  Andrzej Sawuła
  Benjamin Siband
  Yu Tang
  Rashid Umarov  
  Antonio Vilei
  Martin Wunderlich
  Michael Zakharov

Також допомагали:
  Sabine Cretella
  Dmitri Gabinski
  Jean-Christophe Helary (координатор команди локалізації)
  Vito Smolej (координатор створення документації)
  Samuel Murray
  Marc Prior
  та багато, багато інших прекрасних людей.

(Якщо ви вважаєте, що серйозно допомогли проекту ОмегаТ, але не бачите вашого імені в списку, будь ласка, повідомте нам про це).

ОмегаТ використовує наступні бібліотеки:
  HTMLParser 1.6 (автори: Somik Raha, Derrick Oswald та інші; ліцензія: LGPL)
  MRJ Adapter 1.0.8. Автор - Steve Roy (ліцензія LGPL)
  VLDocking Framework 2.1.4 розроблено VLSolutions (ліцензія CeCILL)
  Hunspell. Автори: László Németh та інші (ліцензія LGPL)
  JNA. Автори: Todd Fast, Timothy Wall та інші (ліцензія LGPL)
  Swing-Layout 1.0.2 (ліцензія LGPL)
  Jmyspell 2.1.4 (ліцензія LGPL)
  SVNKit 1.7.5 (ліцензія TMate)
  Sequence Library (ліцензія Sequence Library)
  ANTLR 3.4 (ліцензія ANTLR 3)
  SQLJet 1.1.3 (ліцензія GPL v2)
  JGit (ліцензія Eclipse Distribution)
  JSch (ліцензія JSch)
  Base64 (суспільне надбання)
  Diff (ліцензія GPL)
  JSAP (ліцензія LGPL)
  orion-ssh2-214 (ліцензія Orion SSH для Java)
  lucene-*.jar (ліцензія Apache 2.0)
  The English tokenizers (org.omegat.tokenizer.SnowballEnglishTokenizer and
  org.omegat.tokenizer.LuceneEnglishTokenizer) use stop words from Okapi
(http://okapi.sourceforge.net) (ліцензія LGPL)
  tinysegmenter.jar (ліцензія Modified BSD)
  commons-*.jar (ліцензія Apache 2.0)
  jWordSplitter (ліцензія Apache 2.0)
  LanguageTool.jar (ліцензія LGPL)
  morfologik-*.jar (ліцензія Morfologik)
  segment-1.3.0.jar (ліцензія Segment)

==============================================================================
 5. ОмегаТ працює неправильно? Потрібна допомога?

Перш ніж повідомляти про помилку, переконайтеся, що ви уважно прочитали документацію. Можливо, це не помилка, а особливість ОмегаТ. Якщо в лог-файлі ОмегаТ ви бачите слова «Error», «Warning», «Exception» або «died unexpectedly», тоді, ймовірно, ви дійсно виявили проблему. Файл «log.txt» розташований в папці налаштувань користувача, для отримання детальнішої інформації, прочитайте інструкцію.

Далі - потрібно впевнитися, що про цю помилку ще не повідомили інші користувачі. Для цього перегляньте звіти про помилки на сайті SourceForge. Якщо ж ви впевнені, що ви перший, хто знайшов якусь відтворювану послідовність дій, яка викликає щось неправильне, будь ласка, заповніть звіт про помилку.

Хороший звіт про помилку має містити три важливі пункти:
  - Послідовність дій для відтворення помилки;
  - Опис того, що мало статися;
  - Опис того, що відбулося насправді.

Ви можете прикріпити копії файлів, фрагменти логів, знімки екрану - все, що на вашу думку, допоможе розробникам знайти і виправити помилку.

Щоб переглянути архіви списку розсилки для користувачів ОмегаТ, зайдіть на:
     http://groups.yahoo.com/group/OmegaT/

Щоб переглянути сторінку звітів про помилки та надіслати новий, перейдіть за адресою:
     http://sourceforge.net/tracker/?group_id=68187&atid=520347

Щоб відстежувати стан свого звіту про помилку, можна зареєструватися на SourceFourge.

==============================================================================
6. Відомості про випуск

Детальні відомості про зміни в цій та попередніх версіях наведено у файлі «changes.txt».


==============================================================================
