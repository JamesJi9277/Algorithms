input是一堆classes,每个classes有很多schedule，比如周一周三1-2点，周二周四1-2点
outPut: possible schedule that you can take all the classes

class Course {
	int courseId;
	int day;
	int start;
	int end;
	public Course(int courseId, int day, int start, int end) {
		this.courseId = courseId;
		this.day = day;
		this.start = start;
		this.end = end;
	}
}
public class courseSchedule {
	private class Comp implements Comparator<Course> {
		public int compare(Course c1, Course c2) {
			
		}
	}
	public ArrayList<ArrayList<Course>> sort(ArrayList<ArrayList<Course>> courses) {
		ArrayList<ArrayList<Course>> res = new ArrayList<ArrayList<Course>>();
		if(courses == null || courses.size() == 0) {
			return res;
		}
		ArrayList<Course> temp = new ArrayList<Course>();
		helper(courses, res, temp, 0);
		return res;
	}
	private void helper(ArrayList<ArrayList<Course>> courses, ArrayList<ArrayList<Course>> res, ArrayList<Course> temp, int index) {
		if(index == course.size()) {
			res.add(new ArrayList<Course>(temp));
			return;
		}
		for(int i = index; i < courses.size(); i++) {
			for(int j = 0; j < courses.get(i).size(); j++) {
				temp.add(courses.get(i).get(j));
				if(isValid(temp)) {
					helper(courses, res, temp, i + 1);
				}
				temp.remove(temp.size() - 1);
			}
		}
	}
	private boolean isValid(ArrayList<Course> courses) {
		Comp cmp = new Comp();
		Collections.sort(courses, cmp);
		for(int i = 1; i < courses.size(); i++) {

		}
	}
}