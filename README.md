# N11 Event Planner

## Gereksinimler

- Java 17 ve üstü

## Derleme ve Çalıştırma

- Proje dosyalarını bilgisayarınıza klonlayın: `git clone https://github.com/enisyalcin/n11-vaka-calismasi.git`

- Terminalinizden proje dizinine gidin.

- Projeyi `mvn package` ile paketleyip JAR dosyası haline getirin.

- Projeyi `java -jar ./target/n11-vaka-calismasi-0.0.1-SNAPSHOT.jar` komutu ile çalıştırabilirsiniz.

## Tercihler

- Bazı ucu açık durumlar vardı. Mesela Networking Event 17:00'de biter diyor ancak verilen
  örnekte `05:00PM Networking Event` başlayan etkinlik var. Eğer Networking Event için süre kalmıyorsa onu planlamaya
  eklemiyorum.
- Etkinliklerin seçilme sürecinde algoritma olarak [Knapsack](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
  algoritması kullanıldı. İstenilen periyodlarda tercih
  yapabilmesi ve Dinamik Programlama algoritması olması sebebiyle tercih edildi.