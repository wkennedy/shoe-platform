import Grid from "@material-ui/core/Grid";
import {withStyles} from "@material-ui/core";
import Container from "@material-ui/core/Container";
import React, {Component} from "react";
import MaterialTable from "material-table";
import fetch from 'isomorphic-unfetch'

const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
    },
    formControl: {
        minWidth: 120,
    }
});

class Home extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        return (
            <Container maxWidth="sm">
                <Grid container spacing={8}>
                    <Grid item xs={12}>
                        <MaterialTable
                            columns={[
                                {title: "Brand", field: "brand"},
                                {title: "Model", field: "model"},
                                {title: "True To Size", field: "trueToSizeAvg"}]}
                            data={this.props.trueToSizeAverages}
                            options={{
                                sorting: true,
                                grouping: true
                            }}
                            title="True To Size Values"
                        />
                    </Grid>
                </Grid>
            </Container>
        )
    }
}

Home.getInitialProps = async function ({req}) {
    const baseUrl = req ? `${req.protocol}://${req.get('Host')}` : '';
    const trueToSizeAveragesResponse = await fetch(baseUrl + "/api/shoes/trueToSizeAverages");
    const trueToSizeAverages = await trueToSizeAveragesResponse.json();

    return {
        trueToSizeAverages
    }
};


export default withStyles(styles)(Home);