package Programmers;

public class 스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = 0;
		boolean check = false;

		for (int i = 0; i < skill_trees.length; i++) {
			int skill_order = -1;

			for (int j = 0; j < skill.length(); j++) {
				char user_skill = skill.charAt(j);

				if (skill_trees[i].indexOf(user_skill) > skill_order) {
					if(check) break;
					skill_order = skill_trees[i].indexOf(user_skill);
				} else {
					
					if (skill_trees[i].indexOf(user_skill) == -1) {						
						if(j == skill.length() - 1) answer++;
						if (!check)
							check = true;
						continue;
					} else {
						break;
					}

				}
				if (j == skill.length() - 1) answer++;				
			}
		}

		System.out.println(answer);
	}

}
