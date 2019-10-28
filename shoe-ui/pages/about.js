import React, {Component} from "react";
import {Box, Container, Paper} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import Card from "@material-ui/core/Card";
import CardHeader from "@material-ui/core/CardHeader";
import CardContent from "@material-ui/core/CardContent";

class About extends Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
        <Container maxWidth={"xl"}>
          <br/><br/>
          <Grid container spacing={10}>
            <Grid item xs={6}>
              <Card>
                <CardHeader
                    title="What is it"
                />
                <CardContent>
                  content
                </CardContent>
              </Card>
            </Grid>
            <Grid item xs={6}>
              <Card>
                <CardHeader
                    title="Tech Stack"
                />
                <CardContent>
                  <ul>
                    <li>
                      Front-End - Javascript / React / NextJS / Material
                    </li>
                    <li>
                      Back-End - Java / Spring-Boot / Spring-Data
                    </li>

                  </ul>
                </CardContent>
              </Card>
            </Grid>

            <Grid item xs={12}>
              <br/>
              <Box>
                <Typography variant="body2" gutterBottom>
                  For any question please contact: <a href="mailto:will.n.kennedy@gmail.com">Will Kennedy</a>
                </Typography>
              </Box>
            </Grid>
          </Grid>
        </Container>
    )
  }
}

export default About