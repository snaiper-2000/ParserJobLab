import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public static int url2 = 1;

	//User user = new User();

	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		parser.gsoupConnect(url2);
	}

	/**
	 * 
	 * @param position2
	 */

	public void numberPage(String position2) {

		// System.out.println("����� �������� ��"+url2);

		if (url2 < 2) { //�� ����� 75

			url2 = url2 + 1;
			Parser parseNumber = new Parser();
			try {
				parseNumber.gsoupConnect(url2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(" ����� ����� ��������" + url2);
		
		//PrintTxt print = new PrintTxt();
		//print.print();
	}

	private void gsoupConnect(int url2) throws IOException {
		
		User user = new User();

		String url1 = "http://joblab.by/search_resume.php?srcity=4&page=";
		String url3 = "&submit=1";
		String url = url1 + url2 + url3;

		// �������� �������� ��� ��������
		Document conno = Jsoup.connect(url).timeout(10 * 1000).get();

		// ����� ��������, ������� ����� ���� �����
		Elements airships = conno.getElementsByClass("brd_t");

		// System.out.println(airships);

		// ���������
		String position = airships.select("span[class=prof]").text();
		if (position != null) {
			System.out.println(position);
		} else {
			System.out.println("null");
			return;
		}
		user.setPosition(position);

		// ������ �� �������� ������������
		//String urlUser;
		String urlUser = airships.select("span[class=prof]").get(0).getElementsByTag("a").attr("href");
		if (urlUser != null) {
			System.out.println(urlUser);
		} else {
			System.out.println("null");
			return;
		}
		user.setUrlUser(urlUser);

		parseUserUrl(urlUser, user);

		//user2Parse(conno);

		return;

	}

	/**
	 * ����� ������ �� 2 ������������ �� �������� ��������
	 * 
	 * @throws IOException
	 */
	public void user2Parse(Document conno) throws IOException {
		
		User user2 = new User();
		
		String position2 =null;

		for (int i = 1; i < 20; i++) {

			// ���������
			position2 = conno.getElementsByClass("prof").get(i).text();
			if (position2 != null) {
				System.out.println(position2);
			} else {
				System.out.println("null");
				return;
			}
			user2.setPosition(position2);

			// ������ �� �������� ������������
			String urlUser2 = conno.getElementsByClass("prof").get(i).getElementsByTag("a").attr("href");
			if (urlUser2 != null) {
				System.out.println(urlUser2);
			} else {
				System.out.println("null");
				return;
			}
			user2.setUrlUser(urlUser2);

			/*
			String nameAndAge2 = conno.getElementsByClass("prof").select("p").text();
			System.out.println("��� �� ����� "+nameAndAge2);*/

			parseUserUrl(urlUser2, user2);
		}
		Parser parser2 = new Parser();
		parser2.numberPage(position2);

		return;
	}

	/**
	 * ����� ������ �������� ���������
	 * 
	 * @param urlUser
	 * @throws IOException
	 */

	public void parseUserUrl(String urlUser, User user) throws IOException {

		String httpUrl = "http://joblab.by/";

		String fullUrl = httpUrl + urlUser;
		// System.out.println("!!!"+fullUrl);

		// �������� �������� ��� ��������
		Document conno2 = Jsoup.connect(fullUrl).get();

		// ���
		String name = conno2.getElementsByTag("tr").get(2).getElementsByTag("tr").get(3).getElementsByTag("td").get(1)
				.text();
		if (name != null) {
			System.out.println(name);
		} else {
			System.out.println("null");
			return;
		}
		user.setName(name);

		// �/�
		String money = conno2.getElementsByTag("tr").get(2).getElementsByTag("tr").get(7).getElementsByTag("td").get(1)
				.text();
		if (money != null) {
			System.out.println(money);
		} else {
			System.out.println("null");
			return;
		}
		user.setMoney(money);

		// ����� ������
		String placeOfWork = conno2.getElementsByTag("tr").get(2).getElementsByTag("tr").get(8).getElementsByTag("td")
				.get(1).text();
		if (placeOfWork != null) {
			System.out.println(placeOfWork);
		} else {
			System.out.println("null");
			return;
		}
		user.setPlaceOfWork(placeOfWork);

		// ������ ������
		String schedule = conno2.getElementsByTag("tr").get(2).getElementsByTag("tr").get(9).getElementsByTag("td")
				.get(1).text();
		if (schedule != null) {
			System.out.println(schedule);
		} else {
			System.out.println("null");
			return;
		}
		user.setSchedule(schedule);

		// �����������
		String education = conno2.getElementsByTag("tr").get(3).getElementsByTag("tr").get(9).getElementsByTag("td")
				.get(1).text();
		if (education != null) {
			System.out.println(education);
		} else {
			System.out.println("null");
			return;
		}
		user.setEducation(education);

		// ���� ������
		String experience = conno2.getElementsByTag("tr").get(3).getElementsByTag("tr").get(10).getElementsByTag("td")
				.get(1).text();
		if (experience != null) {
			System.out.println(experience);
		} else {
			System.out.println("null");
			return;
		}
		user.setExperience(experience);

		// ���
		String sex = conno2.getElementsByTag("tr").get(3).getElementsByTag("tr").get(11).getElementsByTag("td").get(1)
				.text();
		if (sex != null) {
			System.out.println(sex);
		} else {
			System.out.println("null");
			return;
		}
		user.setSex(sex);

		// �������
		String age = conno2.getElementsByTag("tr").get(3).getElementsByTag("tr").get(12).getElementsByTag("td").get(1)
				.text();
		if (age != null) {
			System.out.println(age);
		} else {
			System.out.println("null");
			return;
		}
		user.setAge(age);

		// ���� �����������
		String dateReg2 = conno2.getElementsByClass("small").text();
		// System.out.println(dateReg);
		String[] masivDateReg = dateReg2.split("�");
		String dateReg = masivDateReg[1];
		if (dateReg != null) {
			System.out.println(dateReg);
		} else {
			System.out.println("null");
			return;
		}
		user.setDateReg(dateReg);
		
		// ���
		Element phone = conno2.getElementsByTag("tr").get(2);
		System.out.println(phone);
				
		
		/*PrintTxt print = new PrintTxt();
		print.print(user);
		*/
	}

}