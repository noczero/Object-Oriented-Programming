package employees;

public class DisplayReports extends JasperReports {

    public void showEmployees() {
        m_report_source = "rptEmployees.jrxml";
        m_sql_stmt = "SELECT * FROM employees ORDER BY employee_id";
        showReport();
    }
}
