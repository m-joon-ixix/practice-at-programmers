/*
Skill Trees: Sequences of primary skills to learn in advance - Summer/Winter Coding Problem (~2018)
*/

public class SkillTree {
    public static void main(String[] args){
        String skill = "CBD"; // sequence required for skill learning
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees)); // number of possible skill trees among skill_trees
    }

    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        boolean possible;
        boolean[] learned;
        int skillIdx;
        for(String skillTree : skill_trees){
            possible = true;
            learned = new boolean[skill.length()]; // did we learn each skill in advance?
            skillIdx = 0; // idx of skill that needs to be learned now
            for(int i = 0; i < skillTree.length(); i++){
                // for each skill of skillTree
                if(idxOfChar(skill, skillTree.charAt(i)) == -1) continue; // if this skill is not in skill sequence

                // if pre-requisite skills are not learned
                if(!trueInAdvance(learned, idxOfChar(skill, skillTree.charAt(i)))){
                    possible = false;
                    break;
                }

                if(skill.charAt(skillIdx) == skillTree.charAt(i)){
                    learned[skillIdx] = true;
                    skillIdx++;
                }
            }

            if(possible) answer++;
        }

        return answer;
    }

    static int idxOfChar(String str, char ch){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch) return i;
        }
        return -1; // if ch doesn't exist in str
    }

    // is it all true in the arr before the idx?
    static boolean trueInAdvance(boolean[] arr, int idx){
        for(int i = 0; i < idx; i++){
            if(!arr[i]) return false;
        }
        return true;
    }
}
