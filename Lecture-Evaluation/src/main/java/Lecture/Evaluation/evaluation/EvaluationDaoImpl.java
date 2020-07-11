package Lecture.Evaluation.evaluation;

public class EvaluationDaoImpl implements EvaluationDAO2 {
@Override
public int delete(int evaluationID) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}@Override
	public String getUserID(int evaluationID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}@Override
		public int like(int evaluationID) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}@Override
			public int write(EvaluationDTO evaluationDTO) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}public EvaluationDaoImpl() {
				// TODO Auto-generated constructor stub
			}public default ArrayList<EvaluationDTO> getList(String lectureDivide, String searchType, String search, int pageNumber) throws Exception {};
	
}
