# Trendyol Test Automation

Selenium WebDriver ve TestNG kullanılarak geliştirilmiş Trendyol e-ticaret platformu test otomasyon projesi.

---

## Teknolojiler

- Java 18
- Selenium WebDriver 4.41.0
- TestNG 7.12.0
- WebDriverManager 6.3.2
- iTextPDF 5.5.13.3
- Jakarta Mail 2.0.1
- Lombok
- dotenv-java

---



## Kurulum

### Gereksinimler

- Java 18+
- Maven
- Chrome tarayıcı

### Adımlar

```bash
git clone <repo-url>
cd trendyol
```

Proje kök dizinine `.env` dosyası oluştur:

```properties
MAIL_FROM=ornek@gmail.com
MAIL_PASSWORD=xxxx xxxx xxxx xxxx
MAIL_TO=alici@gmail.com
MAIL_SMTP_HOST=smtp.gmail.com
MAIL_SMTP_PORT=587
```

> Gmail kullaniyorsan normal sifre yerine App Password olusturman gerekir.
> Google Hesabim > Guvenlik > 2 Adimli Dogrulama > Uygulama Sifreleri

Bagimliliklari yukle:

```bash
mvn clean install
```

---

## Test Senaryolari

| Test | Aciklama |
|------|----------|
| test01 | Trendyol ana sayfasinin acilamasi |
| test02 | "Kategorilerdeki Indirimleri Kesfet" metninin dogrulanmasi |
| test03 | Erkek Giyim kategorisine gidilmesi |
| test04 | Jeans, Armani Exchange, 30-32 beden filtrelerinin uygulanmasi |
| test05 | Filtre sonrasi urun bulunamadi mesajinin dogrulanmasi |
| test06 | Onerilen ilk urune gidilmesi |
| test07 | Urun bilgilerinin alinmasi (isim, satici, beden, fiyat, ozellikler) |
| test08 | Urun bilgilerinin PDF olarak olusturulmasi |
| test09 | PDF dosyasinin mail eki olarak gonderilmesi |
| test10 | Urunu sepete ekleme |
| test11 | Sepet sayfasina gitme |
| test12 | Urun adedini 3'e cikartma |
| test13 | Urunu sepetten silme ve mesaj dogrulamasi |

---

## Testleri Calistirma

```bash
mvn test
```

Tek test calistirmak icin:

```bash
mvn test -Dtest=TrendyolFlowTest#test01_openHomePage
```

---

## Notlar

- PDF dosyasi proje kok dizinine `urun_bilgisi.pdf` olarak kaydedilir.
- Testler birbirine bagimlidir, sirali calistirilmalidir.
- Her test arasinda 3 saniye bekleme suresi vardir.
