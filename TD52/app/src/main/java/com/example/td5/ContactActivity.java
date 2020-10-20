package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView)findViewById(R.id.rvContacts);

        contacts.add(new Contact("Jean","Pierre", "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMWFRUVGRgXFxgYGBYXGBcYFxcXFxUXFxYYHSggGBolGxUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGxAQGy8lHyUuLy0tLS0tLS0tLS0tLi0tLS0tLS8tLS0rLS0tLS0tLS0tLS0rLS0tLS0tLS0tLTUtLf/AABEIALcBEwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAAAgMEBQYBBwj/xABDEAACAQIEAwUEBwUGBwEBAAABAhEAAwQSITEFQVEGEyJhcYGRobEjMkJSwdHwBxQVM2JTcpLC4fFDVIKTorLSJBb/xAAZAQEAAwEBAAAAAAAAAAAAAAAAAQIDBAX/xAAsEQACAgIBAwMCBQUAAAAAAAAAAQIRAxIhBDFBE1FhIpEjMrHR8BRxgaHB/9oADAMBAAIRAxEAPwDw+iiigCiiigCiiigCiiigCiiigCiiigCiugUruzQCKKfXD01cAB0oBNFFFAFFFOC0aAbopxbR6U7+7GgI1FSP3c10YU86AjUVK/dfOuHDedARqKeazTRFAcoooigCiiigCiiigCiiigCiiigCiiigCiiigCilqtIoAFKKUpbZ0p3uCTpQEaKUiE1Kt4Rjy1qbg+HEGWG1AQ7doDenESTVicIuYn4VwYYlugFQCO8BY+NQnsc6s7uGXnTGJcaADQUJKt6Et9adxEU3cYQIqSDllZavQOx3YvE4q2z27GYNoHeFTTox316TS/2LdjreOxD3b4mxh8pKna47TlVuqgKSRz0GxNfSQdVAAgACAANAPIDYVDJPEMD+xLEGO+xNq31CI9z4kpV3Z/Yfhvt4q+f7otL81avTmxS9RShiV61X/JJ5/b/Y9w1d1vOfO6wn/BFLf9k/DI/kv/3rv/1W5uYtImaZuXxUMkwj/sq4Z/ZP/wB67/8AVN2v2a8OQyLBaOTu7D3Ewa2OIxAFVmI4io56kxVWyyRCw3ZbBW5y4TDj1s22+LCYqRbwlq2CEw+HC8wLarPsAiahX+NKJ12j2zVPju06jaqWi1Mk43gHDnMthLU7sAiqdeuXes5xf9neAcTaNy0TtlfMoPmryf8AyFM4njrMT51HPEWOhao2ZOpiePdk72Hkg96o3KjUeZUE6ehNZ2vXcO+YkTJMgH57+2sZ237PCwwupojtBXo0E6eRAOnka1hO+GZyhXKMrRQaK1MwooooAooooAoooFAFdUa06OkU5bXyoBl25V21ampVrDU9aSgO4PDzvUqwsEgCn8NapxbQnSgEhiBoNaTaV+ZqQthqct2DVSSKaAvnUxsETsaj3ME1AM3VqJcs1PayRvUFrsGCDB50BBv2qii3VpibPnUQnpUg9i/YTdtW8LiGuMqzeAGYgTFtTpP96vVDj7AbKXQHoT1rwDsOD3UDfvSw9SEH+UV6Vwyxm1Op3Ncbzrdxo6Vi+lNm3bHYcj661BxOPwwEl1/XsquXC+lNYnh2Ybb6VZzvwQoofTimGecjzG8AwPUxFO4Tilu4SivmI5QQdN9CKqMPw1Ar2wDA36wYmQBpT+EwaWrgZdNNd589/ZVNq5LuKO8TxBBiaobjEmJrS4rDhtRVHxHDRrWblbJSM5xe0RNZnE3QN622NQXLfpI0rF8Ts70bNILkiDFLTqYhaq3WKcsdd43/AF7aujVwRoFuEZYMHQ+/X51WftIxZK2UI3lz5EAAAcvtGn7DDJaQHRVyyd9yfxj2VUftAuzcsrzW2J9p5+7410QXJx5VSMsTXKKK3OUKKKKAKKKKAIpQtmnbCdakBaAj27LU6MO551KsEVLSys70IK1MPc61NSwwiTUkoo51G4jeyIOs1IJ1q28aGn7eHufeFSOz9sXB4jyp64FE61AGRYf74ptcM/8AaVP8IQaSajAqeRFCSKMG4Jm4aQ+GflcOlTlxKE5QCT6UxeRi5K7RUArb+GuEH6QyfSoV3A3ANXmrq/hzlnn0qIhJU9RQFW2CY6s1CWMpqQzsTEUq8jD7NAarslci2B/WfkP17a9Y4AkrPWvHezDxb/6z8Mv517R2SAa2K81x/GZ3X+EiyNs0iDty3qyS1XWs1MovwUUinxNqXLfr0PUb++q/E3QGJq7viCfb+VZriN0B655XRvGmWFm5IprG2sy1XJjwOdWOBxKvbczqD+FThX1UJqlZk7z5XK/erLcYBDHpVv2pxGVsw5Gfcaldp8CDZW4uxUH3610ahcNMxD2tJplU1A6A+/8ARFTLpGnw9YI/E0hLDnVFJPoT8qiDNpNLuLwg8aqTpoJ6D/SazHHL5uP3pn6QsV/uzCj2AR7K12JsqAz6gZSCDoQYMeyszx62oTDxubWb2m7c/KuzHwcWbmNlLRRRWxyBRRRQBXVrlAoCQiVKS1I8qjWqlWwaEEq1btwJ1qX3qDYVHt2z0pw26A4rgGYqv4vJAY9ansulReKAd0Os0BacAvAKPMCpFqzmO/OoPCU8CnyFTEWNZoCzuopETXHtqIgzUW2pialKBGlQWJmDto06aCmsiiYp3CrltS3Oo1iJNQDl9ABNVpTfzqyv66VBdTQEQADYVGxN5idanMKjX1qSC14Cs2pjTM3yFerdjEBsjyJHx/1ry7gA+igfeNb/ALIcSFliraq0T5HrXjdRJLLyenji3i4N3atkbGn+6nnSrTLEyIqNieK210WSTzjT40yThjjcmYpSk+EZni2JId4kjMwO/pvWUxTMDrPvrUYpwSfPU9d6zvFSCfCIAEbkk76mvKjm3kenDHSKe7iG2mu8K4ubLMGJyuB7CNj8/hTN5dddPXT51BvWprvxScXYlBNUK7QYkXNjM1qsI4u8KQ7lFyk85XSsXiF0qT2e4uba3LB+q0su+jEAH5D3muvHPa2zHLiqKod4NgFuOTcMJbUs0bkKJgDma0vG8aLZFuxdSyCyrBtsxAyAyIUjUSddiKy3Dce1r7XiIhiunrE01jcWz3u8iRmDbmdspXX3zWsXUeDFq5cljibmZmnF23j7NzvLc6CY8OU1VJw1MS6ocPnIXKgt3NYktlUSs6sx250u/bFycuUZjAzHKZI2nbkaing2d0U3rUO6oyh1DIHIUOUYgsskSQDA1MDWunHT5OXLa4XYbxXZiwGKm3eRgYKl8rKejK6Eg+6qq/2czAmwzFl3ttEn+6w3O2hA9tbjF2mttZW/eu3HMA3LmQhLQHgSVcsSMxPigjQVT4u6ljEMyXGyq0G4n2rROVyAegkx7OdTckzP6WjAERodCKK+ieEcH4Ti7S38Rbw4vtmW70a5bY23cQ0ZWZCw8mFFa2zPU+daKKUh11qSo9hG1g1eWMNpVHbOYxFaHB2GC70IHRbpJt0+s9Kj4m8y7AGgOG3UDjyRbU/1fgamYLiAckOMpHmKruN45bhVE1AO/U7aUBacM0tj0HyqSo6g03w1dPH4QB8qZxvaG3myoJUc/wAqEllbVjudKk2nygaVTWO0KHSI9asMPj1faDUULJl26W9BT628oqN+8KCJIApF7ilozDggedRRNnb29RzB0mkfvqt9UzSbhGUnnQC8tRbwqv4bxJ3uFDBGuvpVhaw9y6/d21LudlUFj6wNh51L7EEzgdwrmHnI6TG3wrVYHEDSqTAcI7uRcu2y+k21OcpoSCXHhJ8JEKT60/i7nduQT026lQfxFeP1cN3aPV6R8Uz0nA8WzWFWdQxU+gEj5/CmWxEe2slwnHfRljsG+ayPlU3DY43Gyj9bmvKyYpN/V4O2MEuxe4l1is1xC7H69/zNTrt1i2SCSeVReIcNu7ka1nijqzWqM65lpb/fnrQ+1Lvjwg9aYYH5V6EeSFHkjYhNJ6VXWW+k66fgDVrjVgVVWSO8B8j8q6MTtMrlRJc12xLMF6kCm7jTUvggHegkTAY/AkT7q0grOWXBC4pcm53SjRNz/Vz/ACqq7Z4Y27yKfrd0ub1zMNPYBWhtYDIiu5/nEMY5AMS3vI+FUPb3Ei5ipEaW0XT0n8a6cTfq18fsY9Sl6F/P7/sT+E3Hv2ldpbK5V41JCgNO/Q7+Rprj2M+iZQkHNvI2J0Htg1G7JsSt1QTuh8h9cE/KpHG+HFEvA7iCPTMOftNdWvNnmbeCqw9jOoaRr1nlp08qKjYc+EUUafuaqaohUUUVcxOrO4pzvXP2m95pK3SKet4wqIAFAcR7vIv7zXDauHfN76eTHN0qXaxvlQgg2cAzHcCrDAYEI2YnMRtpTq4wchXUx0Halkj+JVnBXWDvFVv8I10Jj0qx/iXlXbeLJqLBBXgoP2j7qcHCVXUO0/rpU1Mb5U6l2eVLBWjgoOrXGP686LvAljRz7RU25idSKTavT76WCubgbD7fw/1rn8LuRHeadNflWoVyQEVCzuQqqBJJOwA51LuXbWB08N7F7zo1rDnovK5cH3thy+9VZTrjyWUbK3h/ZJbKrdxd1rKHVUUDv7o5ZVP8tT95h6Kd6TxXtA+U2cMgw1k7hZNy553bh1Y+3TlG1Qsbj3uMXdizHUkmSTUPvDMmoWO+Zc/oN6/KWXZa4RcdiSSq5h6gxr/iq1xNwtBOk6n2bCPfVVwLU3I3IEe/X8DVm1su4DQAnL6oJOw9v4cq487Smej0auJf8LwBuYU5PrFhdjSe7UZHMdJn/Cabw2I7twysJUg6Eb/rlRwzidxLqXVyhkgBYhQAIygA/VgxvWz4FxDhhaWw6Ye4P6QyTyKGNPcK82T5ds9CSlBXra+DR8IwOdEu3ECsygxG06+zlUPtGq27VxzyUx6kQAPMmBXMT23s22KIrXiPtABE2mJJJO/Ssd2j4vexR8QCINQgMiepJ+sat+FCNLucmPDmnO3wjO/YX3Ug1zE9JosKz6AfrrVUkkeik7EYsTVObcNPlWoXANGojly/Rqqx2GhvOpxZUnqimQro1qy4Eg70g80cD1jSmP3aBJp3h9zJcRxuDP4EfMV3QVNM4ZStMkYGbjJbcEhUZQBE6zA182isT2sQDFOBJAW3uIP8pNxJg1u0tFLrm1cBhg5Y72wDIJnRlBI2PTSsF2lxXeYq8/3nJ2iBAgRygQIrpw3u2zl6mtEl2JnY9iGeOZtj/wAvyBq67TvpdmIYBRBP3hPyqt7F4IvnPLMnXlM/+wpzti8EW/aY2P6kV13wee1yUltNKKewrKEAO/6iisnI2USnooorQzCnLU8qbpavA0oCWIG9KN5agzUjDYS5c+pbd+XhVm16aDegHxiaUuIFO2eAYpmyDDXs28G2ywOpLABR5mpt3shiUQO5tBDGouK8BtZi1mMARJjSaq5RXdkqLfYrzfHSki/WntdhlKFji1nkBbY5h1UzqNtZH5S7fYW0DDXX2BlcjSGiI2gyZ5ggbisn1GNeTRYZ+xlcO004cRyFbG/2DsIM370+ULq2VQS2bUd2eUHfNy25UxhexqWlFy/eDKCpKwwm2zBSYQzIObUE+nWP6nH7k+hP2Mc4ZzCyW8vMgCempA9SKtsF2cxi6m1oozGGQ/aKxofraEx0Br0DgvDbZUqhizh470pLm4rENlXMSVPWSFWJ02pGL7TKbqWLRSyxxHi0RgLbFBnNyWQkICAo2yatI1yfUyf5UXWBLuyHf4XdweEe9AF9tGMgm1bbkkSCzAhiQdFZRzavPmYkkmtvxrtd35YKABaNy4QQZhtVQjnAAHpFZ6zgsO9q25uGySuoIBzRoW8Tjc9NKnFkfLmiMmPsolMTS8kVaDhuEG+LY+iKP87U5+4YP/mm9sD/AC1v60fn7My9J/H3RNwPAbtvCpjpGR2KBBo8agNLaQY5TuKceCszrOo16FSfYSPf5VeugXhv7uodghZ0diAfFluwFiYyyR5NVHbSQp+8p+AY/MVwZpb2/k9Dp46UPYhMpQgkFkQkcpYA0q5fiH948udJxzaWW0/lgeXgZl5+kV26Po9evz/2NcdcK/7Hu42mXmBs6Z4mdqbxrTM6UrA3Pol9Ki4ozPqK5Um2XyJIrb9vSd/l5VJ4QdaiYxzNTOEuIY9IHzNa5L0ME+TUpZAWTqflWQ40PGPWtJisboPSstxRszoOrR8q5ukhLe2YZH3YhUnU7UxccKGf7oke4/OascaAogVQ8Sb6OOpHuH6Fe6vCOGKs0nZHCZn7q5qtxEultdEBYkGP6so9orzzi1truLvRt3rgkDQAMRPuFen9k7hQM5P1bCRPIZgXH+FGNYnguEbFXksCYMvcj7KDV2MczsPNhVunyTkV6rHBPl8LwX/YfCG0igbt4jOmh1GvplrNdrLmfEMeQLezxEf5a9IbCAW3uFQirOp8lJgem3srz+5ZXvEdtVUG5c8xb1A/6mYLXXKWp5sY7SKLELkYqRqsA+sa0V29i1DHPqxMsfM6n4muVKXBZyRV0UUVcyCl2rZYwI9rKo97ECkUq2hYhQJJIAHUnQCgNl2V7IWbi99irrFJyJawv0t17mhyF8ptoAupJO1aXB2MJYDsMHbtzooe9nvCPts0kKu0ZdzPkTgr3H71tFs27pIQAZtCsD7CDYICSZjxE5jyqlZySSSSTuSZmsZ45T8mkZqPg9fwXEnLG5evd0obwrqzuCD4pzwigxAILNzA3qm4jiw912bELaSIADKbrH7zASLYMmB9avOrl5mMsxJHMkk+81suy3YZsQne3TAaciw0kgurBuYaQpAG81hPDDGtpM2jklP6Uidb47buXVzF+5srBKaXLhiFBZQcuupdpY69aseFst5QqWmuWrbZh9KllQxMnO5Pea67CT13BcxWGw2GSzdhCGN1MniEQptjwsYYB7tswduZ65zE42zba1bbKlpi4JtghratmUuY+7c103CwNprJLb8qNG9e7NneuNfD4dUEKJKWyigK2rnTVRqpmBmnQk0riFrvMJiLz3IAICoLij6QQAwYA5UaIiNxoY0qg4Dixas3cjrnuhy7SsXYJYRcJ8MQSSYMkgxpGhPDLithsJfu2zhbxYXctwMrMCzqrSua2ZYLnUyYXURVNEmW2tGU49xRb4R0sm33NqLiKfoxlfKiyACxZmzS0mSI8ovY5ycbZCL4XK2sgAJYOro5iIJCu2vlXoGP7Mr+8lLaYfD27qMCRfZgT4TbUWiFGmVm0BH1tVgVh7uCOG4jkzHKrkMYE5GBBhoj6jGCN59a0Uk04/BXXlMmcX7JX7DYkWgt8W2UXGVka4qR9GGSc0eCNtSprJX1uMZJJP1QDv4dwB0Ej316/wBnsb3uJYLhGXDthpuNl0vPCFXvXJltDcA3OvqKp+I4VmdFtCxbw17Kwuqi94FgBVZMqsFkHxGdANRTH1Fdys8NnnuP4fcshXuBcr/VYMvi3kgGGI03iNRrrV52U4U7M9w2HZVTSZRWzRpJBJJBkR08xXqOFwFjCG0oF64W7sMTZYrprPfIugmCQJBAiKqOPWUt4k3L91nQ6uqA22OkLJJ0HLw5eURFTLPKUdfcRwpSsj8SvjD4QO5drmItmAwlu7ZQlwOD41IDE5t/DEbzlsM4CqxOiPr6SpPwJp/jmIfE2nGVDZQtct5JFxQUKuGJgsCFB1k6E+VRuF2+8tvGzjNryzA/hA9lZOK04N4Se3JKxFqLNqfstcQ6HqDHxNIJ+jboI/Ux/UKc4lcy2SGmWud4p5aqFdfLUCoXDTnt3Omo3G4yn2aVjBfS79/+nrQlwi7wVyLQHSR8ai3L2pHmKXw64ptwSJLNHnGpjrUNRqx8/wANKxjGm0bZKaTGsVrrS8A8W2P9XyX/AFrl7eP11+VItv8ARNH3j/kH41aSuNGddmSr+MJ936+VRrQL3bIHUt7qYuPp7fwFaHsTw0XbwZhIVdJ65iZ19BV8eOmjLMtYN/BV45DmI86peJoczLH1QJ9CAxPuIr1rjfBUZDlAny61juLcQ7r6O7ZYsoyKfEkiInbxaaTvGkRXbo0eZjzJOxODtEYV5YJmUJmIJECwVYQNT/OGg11rU9luB9xZLFUF24MzMlpLShJ8CZV1J2JmdfSszwbiSp3b3ouC2Wa3ZEZQzQc1wjc6D3cq2PZbhl67abE4hotu2ffLltp9RVn6oJn2etadPi0XJh1eX1JWuxWdvLwt2kw0D6TxMeirrr/eIrzPjOICKfIgt/URJtJ5wSzH/StN244sO/uOWGblvCKPqlhy5Qu+k8xPmvEcb3jaSFGwO+u7HzP5DlWtbSvwYr6I/LA8Qfnl/wAK/lRUSitNV7GWzCirpeAMedPW+zcgktEaVHqR9y3py9jP0u3cKzGkgj2EQfhp7a0P/wDM6AzMnrtPP4U+Oyq/eMfrypvEaSMpU/h/CLl6SsKAJzNmCkTBggGYrRJ2TUah2B/vAVpLWDt2bSrbDXb2hZmBzEk/VFxtUURsImATpqaSyquC0cbvkp+Edn7NqbmbvCohmOYIMwIjKBInbU1OucZt22tXbbXQcrPfOYENKsEAJB5sgkzqT0p/FcJxN1wGaJBLkEBBOipbWNwJ18/fXY3hL2/oLfiLQ7sRKQWXu1BUSWzjQbc/Tl/M7k7OiqVJUQ7WGvX+8UFfEUP2yMxAKIVEmYQ667+6u43w3uEt27niZlS47eHNmIkorTMANB5EgmrziXDsUtpL3dWrjMwaz3BYixnYq3eqVgBmAglpDLoSARVX2mwiKxFy4RfyKZIBW4dAcpWSoHi+tH1edawu17fBSdV8llwXs3bfCq7uLb4i4bdhQ0nWAucQSBm9uo2rSXP2fYs3bVq7fDIiOCyqAEIAKpJabjNHTYa765HspxT93kMLGe26OjXN0YOMxRtdAJbLGoLQZifWFtr+/wBrFLcfEX2t3beV5yd4EW4q2XVcqjJngMZIfNrDVnk2TZaDTRhMLwTGNZxBvO3eYPxDUwCyh1VF3zGASd9vZzDWcV3KY29Yz29FBFzI1+27HwqpECBqAdTyHTc2OJZLt+9euHEW2KoLNq0ydxcmSCLhCwc6k3DAJJOgqPhkuX7N61fsJh7YJ7q3eKNmksxfVgDJMmQYIkeWLl5aNV/cz/BuMYi8Ldu3eOHUs1pswVmyZDE6w7EookRrm2p/G3MAlnC8OS8bim6bb58wYCSQ2YQQmbKREj41T9oseWS1h7a/TYcqq3XYMSFABYMMynnoI2BPSrvgfGe5s94MMoxNq0iZrgAzMzjTN0MOdIgGKhxaVr7foxsmVvHLV2wnc/vt23lBuWGS5dynNp3ZvqAjrIBBiRqOdJ4p2ltXrVm29171sasLoud8mmoNxVYP5EN61pOEpisVdxJxGHy4e4wUL3vitsizdVVCtnVjqRpHI15b2s4O9i6Wsr9GNcyZiIkwzKScukDpKnaYGmJKT1bKTevKRa38ZbVHtWWZkbSWEsAQMyk5fENh9X1B5ysDhu6kQQGXwgkeIGWkbc50IB0OlZnA4zvbbJs+/eaArvJEaxoo03JpdnjvjVGEhBkzSxLETDEkmDyjWtXjfKKrIrTN9wHCYPGKLGIutYu8rkjJcnybQHbSRyq24p+z9MNYZ7/EUayqnKBbUMZIhV8ZzEx091edW7jQDbliAZmT8AKfsYZ2iRG3Ig7a8h+jWVKK7HQpyT4lwPXMC4tqMsqqkkndZaZ31MaHlpUfPlBGmuskwffNTBw8nwgr5Al9/KdB61GbDuJlQdp1+YI1rO3XJ1f1EX2RBvOST4vIwfl86cw12BlMaCQZ1PkdfT3Uv9zmJERJER6RoKfOAU6gMZ/qA98rNWc41TJjnUSI9w5RqP8Afnv6V6J+yweG4xIOoA/w6/GsEML4oQEtsomZzH+6Ogr1zsvwBsNhwrfWOp9Tr+VXx8u0ZdTmUoUh3tJeBtOAdcrZRtrlMfGKyOH7Q2bdnLdwxZx4WLBVMEkqDmHmdSKT2mzl8mYidJ/2quscHxLKSjqyKMxPh1A1MjYx0qMje1mOHVRaZc8Bfh95czfR5D/LLd6WG31lQQmYDf5VW9sP2ks4Nm26ZBAHdw0R0YeGfMT5VU8e4N3lw3Ge29s6ra751AgQAogLOm+nOqz+E4PVWW4h6LeS4PPxbfGuiM4pcnNPG27Vfcy2PvvcMnaZgGfaTuT51CIrarwHAb99dHqY+OWD7DUe9wnBTpiDHmy/LKTWizR8GcsM+7MlRVrd4dZk5cQkcpBn4UVf1I/xMp6Uv40WtjBaSVPx/MVJXDDePiaoLWOcbD4GpFvF3iRE/AfMVXVjZGgXDa6jfbxEU8mEExoY6FqpreIv/wBmT7Rp8KfXFYif5J9/z0qKJsv7WESdQYHRmqctjD5rZum54ywOQAldVymBoBBbQwdKzNvH3x/wWHkBNPrxPED/AIMnzVvwqriyyki9WzZ0kMgBgtCz6gF9eXKoly5aS5da01wKy6MSjsID5hCqcqw0wBJyiTUD+NYj/ltOcK8n211eN4nWMO0+lyB7ANT7dKq4MtsiZxqyjZWs4u0pslV7oPla+BlNoMuYKFy6CObE8zGQONuviM4w9rvAYynNAZZGqs8SNoOgyjStBiPpDLYIMevdn27iabsWijZkwQU9cjmffoKtHhFZcsi2uA4xwzdzbBZsxIKySSzfWzHTxcug6VoezfBsZLG9ftWLVhWugydwCqIFBAYS508yBvSF4li4/lMOnhHu1NO2+LYoD+Q523A/A1WWz9iVQcK4zjPpWKrcF1IcWGPiZbRUC6Lh0zeGWXaDpqaVZxV65w+5hr1ghgxZJUu5YsWtklQR9rIegBOx0aucRxnPDwNydQf/AGpl8XiCdLUT1K7+WvlVNPhFtiRieJnubHdYe9bddSncBlBUHTOwz2+UEZhGlZjinE7zEMti9bYHxAhyGHUkz4p5itAvEcX90D2oR6Az86UOJ4r7sf4PxNTGCj4/2HK/Jzg/aBry9237zZuE3HRlLBUvKii02aNQ2Vlg83PWtFewuDxCnCLdv3XvKL4ugpkDd2Jg6C2dfEoH2hIqhbiOKP8Aw1C9PCPfBpFjGYi25e2FUlswggZWIhysPpmEz1mdYEV9PyuBv7mX4nwi/hj3bWnt6hwyic8beOdhOw2J51Spgrh2tv7A3zrW8asYm+q5rcXE0lXQW7gJJJa2TCPrqymDA0G9TeH3b6LD4dARGouWh8ADXRs0jLVNjnAOMFbQtXcI+cPnLi3M+BVAIgEgFSYmDmO29SZRjN21cidBN1Y9NacTiN4TFm3rz738AB+hTv8AEL+kKmmsFlYeWmUH3VjKOxqnRDuCwJHeXV02ZnI/9RpVc9hP7Ue2Z+daAcVxGceCyBz8TTPLzj8hXbvErv3LJP8AePu2kCo0GyM13dufrJrzMfiDT4Frndtj2T8hU65i8Qx0Wwv/AFes7r6e6owsXjuMPz18J9Ne71/1p6Y2RYdjQjY2yhvIVJJhQVkgSBrvtXtfE7ygSYED9fIV4ImGxOhDWPUBg3/iBTt25jjAL22HOWukeUAirxTSoq3Zc9q8ehuSpGhrOcb7c/8A5mweHBRHhbjmASBuqwdQdifzpFzA3GaXt2CSOasw85ld9aatWXWDNkNlK6JlUSQQRAmfrEn0qPTi2nJXROzSpGSuXwec+on50g4ieh9i/lWov37okzaJ+9lJJOo18O3PWaqbt9wTpbOv3R+Vbp34MmitOIZeg9i/lTL3ydzPrUy/cJ5L7qiXG9PZVyliM1FJmipIHRfNKGJNFFALXGRT68UYV2iooWOLxlhz+FOrxxvWu0U1RNsdTtAw5fGnT2mudSP8P/zRRUaobM4e0Nw7XHH/AG/xSnrXaJgNczebNM+wAAV2imqGzFntESOazzU6+8jSlWOPwMssQOpJ+POiio0ROzHxxzmR86WOLA8j69PfXaKo4otbD+L+sUfxcx+c0UU1RNsa/ix35fr/AF99H8VnbWfLX31yip1RFsDxc+f68+VcHFV8/wBf7UUU1Qtnf4snKfl+FLbjgIjIk+2fUeHeiimqGzODjOsR+vdQOM6eXtNFFKRFs4eOCOZ9gHzFNfx0a7+4flRRVtUNmdHaED71IftH0zUUU1RGzGm7TMOpqNe7QE/ZHxooqdUNmVWIx2Y7fOozXTRRViogmuUUUAUUUUB//9k="));
        contacts.add(new Contact("Jeanne","D'arc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Pierre","Menez", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Arthur","Rimbaut", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Richard","Coeur de lion", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Zinedine","Zidane", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Yannick","Noah", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));

        ContactAdapter adapter = new ContactAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}