package pdf.stamping

import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfStamper
import grails.test.GrailsUnitTestCase
import org.springframework.beans.BeanUtils
import org.gmock.GMockTestCase
import com.lowagie.text.pdf.AcroFields

class PdfStampingServiceTests extends GMockTestCase {
  protected void setUp() {
    super.setUp()
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testInteractionWithPdfItextPdfStamper() {
    def ins = mock(InputStream)
    def out =  mock(OutputStream)
    def mockPdfReader = mock(PdfReader , constructor(ins))
    def mockPdfStamper = (PdfStamper)mock(PdfStamper, constructor(mockPdfReader,out))
    def acroFields = mock(AcroFields)
    mockPdfStamper.getAcroFields().returns(acroFields)

    acroFields.setField('name' , 'Stephen Smithstone')

    play {
      PdfStampingService service = new PdfStampingService()
      service.stamp(ins,out)
    }
  }
}
