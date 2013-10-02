package org.eb113.essen.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class EssensMoeglichkeitFactory {

	private static List<EssensMoeglichkeit> allPossibilities = null;

	private static void initPossibilities() {
		FileInputStream fis = null;
		try {
			File file = new File("EssensMoeglichkeiten.xml");
			System.out.println("Absolute Pfad: " + file.getAbsolutePath());
			fis = new FileInputStream(file);
			Properties props = new Properties();
			props.loadFromXML(fis);

			allPossibilities = new ArrayList<EssensMoeglichkeit>();

			Set<Object> keys = props.keySet();
			for (Object o : keys) {
				EssensMoeglichkeit onePoss = new EssensMoeglichkeit(
						props.getProperty(o.toString()), Integer.valueOf(
								o.toString().trim()).intValue());
				allPossibilities.add(onePoss);
			}
			Collections.sort(allPossibilities);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static List<EssensMoeglichkeit> getAllPossibilities() {
		if (allPossibilities == null) {
			initPossibilities();
		}
		return allPossibilities;
	}

	public static EssensMoeglichkeit getRandomMoeglichkeit() {
		Random random = new Random();

		int zahl = random.nextInt(10);

		for (EssensMoeglichkeit keit : allPossibilities) {
			if (keit.getWuerfelAugen() == zahl) {
				return keit;
			}
		}

		throw new AssertionError();
	}

	public static EssensMoeglichkeit getDefaultAuswahl() {
		return new EssensMoeglichkeit("Nicht Anwesend", 0);
	}

	public static EssensMoeglichkeit getBestellung() {
		return new EssensMoeglichkeit( "Bestellung", 1);
	}

	public static EssensMoeglichkeit getLutz() {
		return new EssensMoeglichkeit("Lutz", 2);
	}

	public static EssensMoeglichkeit getBilla() {
		return new EssensMoeglichkeit("Billa", 3);
	}
}
