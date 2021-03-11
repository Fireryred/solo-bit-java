package utility;

import model.*;

public class Factory {
	public static HPLaptop getLaptop(String input) {
		HPLaptop laptop = null;
		if (input.contains("CHROMEBOOK")) {
			laptop = new Chromebook("HP Chromebook 14","Php 17,850.00", "https://cdn.mos.cms.futurecdn.net/g3wPJLSxNpGnv9PZGLHomH-970-80.jpg.webp");
		} else if (input.contains("ELITE")) {
			laptop = new EliteDragonfly("HP Elite Dragonfly","Php 81,440.00", "https://cdn.mos.cms.futurecdn.net/347jbCQnSqziigoDYZssr9-970-80.jpg.webp");
		} else if (input.contains("ENVY")) {
			laptop = new Envy("HP Envy x360 1040", "Php 54,995.00", "https://cdn.mos.cms.futurecdn.net/j6ndSR6hKav95QT83beRB4-970-80.jpg.webp");
		} else if (input.contains("OMEN")) {
			laptop = new Omen("HP Omen 15","Php 67,990.00", "https://cdn.mos.cms.futurecdn.net/YWCwFSLwSi3CPGrvkjqd2Q-970-80.jpg.webp");
		} else if (input.contains("SPECTRE")) {
			laptop = new Spectre("HP Spectre x360", "Php 79,990.00", "https://cdn.mos.cms.futurecdn.net/BWsKGDUhVnQCYUykJSmHxK-970-80.jpg.webp");
		}
		return laptop;
	}

}
