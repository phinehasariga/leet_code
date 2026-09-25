class Solution {
    private TreeSet<String> resultSet = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(resultSet);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            resultSet.add(exp);
            return;
        }

        int i = exp.lastIndexOf('{', j);
        String prefix = exp.substring(0, i);
        String suffix = exp.substring(j + 1);
        
        String[] options = exp.substring(i + 1, j).split(",");
        for (String opt : options) {
            dfs(prefix + opt + suffix);
        }
    }
}