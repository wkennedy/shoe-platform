import React, {Component} from "react";
import fetch from 'isomorphic-unfetch'
import Grid from "@material-ui/core/Grid";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import {withStyles} from "@material-ui/core";
import Container from "@material-ui/core/Container";
import CreatableSelect from 'react-select/creatable';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";

const styles = theme => ({
    formControl: {
        minWidth: 200,
    },
    success: {
        paddingTop: 5
    }
});

class TrueToSize extends Component {

    constructor(props) {
        super(props);

        this.state = {
            brand: '',
            brandOptions: [],
            model: '',
            modelOptions: [],
            trueToState: '',
            success: ''
        };

        this.state.brandOptions.length = 0;
        this.state.brandOptions = this.buildBrandOptions();
        this.handleTrueToSizeChange = this.handleTrueToSizeChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    buildBrandOptions() {
        let brandOptions = [];
        Object.keys(this.props.brandModels).map((brand, i) => {
            brandOptions.push({value: brand, label: brand});
        });
        return brandOptions;
    }

    buildModelOptions() {
        return Object.entries(this.props.brandModels).map(([brand, models], i) => {
            console.log("model: " + models);
            console.log("brand: " + this.state.brand + ":::" + brand);

            if (brand === this.state.brand) {
                models.forEach(model => {
                    this.state.modelOptions.push({value: model, label: model});
                });
            }
        });
    }

    handleBrandChange = (newValue, actionMeta) => {
        if (newValue) {
            this.setState({
                ['brand']: newValue.value
            });
            this.state.modelOptions.length = 0;
            this.buildModelOptions();
        }
    };

    handleBrandInputChange = (inputValue, actionMeta) => {
        this.state.modelOptions.length = 0;
        this.buildModelOptions();
    };

    handleModelChange = (newValue, actionMeta) => {
        if (newValue) {
            this.state.model = newValue.value;
        }
    };

    handleModelInputChange = (inputValue, actionMeta) => {

    };

    handleTrueToSizeChange(event) {
        const target = event.target;
        const value = target.value;
        if (value) {
            this.setState({
                ['trueToSize']: value
            })
        }
    }

    close() {
        this.state.open = false;
    }

    handleSubmit(event) {
        let url = this.props.baseUrl + "/api/shoes/" + this.state.brand + "/" + this.state.model + "/" + this.state.trueToSize; //{brand}/{model}/{trueToSize}

        console.log("url:" + url);
        fetch(url, {method: 'POST'})
            .then((response) => response.json())
            .then((responseJson) => {
                console.log(responseJson);
                this.setState({
                    ['success']: 'Successfully saved'
                })
            })
            .catch((error) => {
                console.error(error);
            })
    }

    render() {
        const {classes} = this.props;

        return (
            <Container maxWidth="md">
                <Grid container spacing={6}>
                    <Grid item xs={12}>
                        <Paper className={classes.success}>
                            <Typography variant="h6" component="h4" align='center' color='primary'>
                                Add true to size values for specific brands and models.
                            </Typography>
                        </Paper>
                    </Grid>
                </Grid>
                <Grid container spacing={6}>
                    <Grid item xs={6}>
                        <FormControl className={classes.formControl}>
                            <InputLabel htmlFor="brand-select">Brand</InputLabel>
                            <CreatableSelect
                                placehodler="Select a brand"
                                isClearable
                                onChange={this.handleBrandChange}
                                onInputChange={this.handleBrandInputChange}
                                options={this.state.brandOptions}
                                styles={{
                                    container: (provided, state) => ({
                                        ...provided,
                                        marginTop: 50
                                    }),
                                    placeholder: (provided, state) => ({
                                        ...provided,
                                        position: "absolute",
                                        top: state.hasValue || state.selectProps.inputValue ? -15 : "50%",
                                        transition: "top 0.1s, font-size 0.1s",
                                        fontSize: (state.hasValue || state.selectProps.inputValue) && 10
                                    })
                                }}
                            />
                        </FormControl>
                    </Grid>
                    <Grid item xs={6}>
                        <FormControl className={classes.formControl}>
                            <InputLabel htmlFor="model-select">Model</InputLabel>
                            <CreatableSelect
                                placehodler="Select a model"
                                inputId="model-select"
                                isClearable
                                onChange={this.handleModelChange}
                                onInputChange={this.handleModelInputChange}
                                options={this.state.modelOptions}
                                styles={{
                                    container: (provided, state) => ({
                                        ...provided,
                                        marginTop: 50
                                    }),
                                    placeholder: (provided, state) => ({
                                        ...provided,
                                        position: "absolute",
                                        top: state.hasValue || state.selectProps.inputValue ? -15 : "50%",
                                        transition: "top 0.1s, font-size 0.1s",
                                        fontSize: (state.hasValue || state.selectProps.inputValue) && 10
                                    })
                                }}
                            />

                        </FormControl>
                    </Grid>
                </Grid>
                <Grid container spacing={6}>
                    <Grid item xs={12}>
                        <TextField
                            id="standard-full-width"
                            label="Enter True to Size"
                            placeholder="Enter a value 1-5"
                            helperText="1: really small, 2: small, 3: true to size, 4: big and 5: really big"
                            fullWidth
                            onChange={this.handleTrueToSizeChange}
                            margin="normal"
                            InputLabelProps={{
                                shrink: true,
                            }}
                        />
                    </Grid>
                </Grid>
                <Grid container spacing={6}>
                    <Grid item xs={12}>
                        <Button id="trueToSizeSubmit" variant="contained" onClick={this.handleSubmit}>
                            Submit
                        </Button>
                    </Grid>
                </Grid>
                <br/>
                <Grid container spacing={6}>
                    <Grid item xs={12}>
                        <Paper className={classes.success}>
                            <Typography variant="subtitle1" component="h2" align='center' color='primary'>
                                {this.state.success}
                            </Typography>
                        </Paper>
                    </Grid>
                </Grid>
            </Container>
        )
    }
}

TrueToSize.getInitialProps = async function ({req}) {
    const baseUrl = req ? `${req.protocol}://${req.get('Host')}` : '';
    const brandModelsResponse = await fetch(baseUrl + '/api/shoes/brandModels');
    const brandModels = await brandModelsResponse.json();

    return {
        baseUrl, brandModels
    }
};


export default withStyles(styles)(TrueToSize);